package com.laveberry.photoniz.photoBoard.service;

import com.laveberry.photoniz.config.jwt.JwtTokenProvider;
import com.laveberry.photoniz.exception.CustomException;
import com.laveberry.photoniz.exception.ExceptionType;
import com.laveberry.photoniz.photoBoard.domain.PhotoBoard;
import com.laveberry.photoniz.photoBoard.enums.MainType;
import com.laveberry.photoniz.photoBoard.model.*;
import com.laveberry.photoniz.photoBoard.repository.PhotoBoardRepository;
import com.laveberry.photoniz.user.domain.User;
import com.laveberry.photoniz.user.enums.Role;
import com.laveberry.photoniz.user.repository.UserRepository;
import com.laveberry.photoniz.work.enums.WorkType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class PhotoBoardServiceImpl implements PhotoBoardService {

    private final PhotoBoardRepository photoBoardRepository;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public PhotoBoardDetailModel findBoardDetail(Integer boardId) {

        PhotoBoard board = photoBoardRepository.findBoardDetail(boardId).orElseThrow(
                () -> new CustomException(ExceptionType.BOARD_NOT_FOUND));

        BoardUserModel boardUserModel = new BoardUserModel(
                board.getUser().getNickName(),
                board.getUser().getEmail()
        );

        return new PhotoBoardDetailModel(board.getId(), boardUserModel, board.getTitle(), board.getContent(),
                board.getReadCount(), board.getCreateDate(), board.getModifiedDate(), board.getWorkType(), board.getType());
    }

    @Override
    public Page<PhotoBoardListModel> findBoardList(String type, Pageable pageable) {

        //TODO 페이지 관련 추가 처리 필요
        return photoBoardRepository.findBoardList(MainType.getMainType(type), pageable).map(board ->
                new PhotoBoardListModel(board.getId(), board.getUser().getNickName(), board.getTitle(),
                        board.getReadCount(), board.getCreateDate(), board.getModifiedDate(), board.getType(), board.getWorkType()));
    }

    @Override
    public PhotoBoard createBoard(CreatePhotoBoardModel createBoardModel, String token) {

        User user = getUser(token);

        PhotoBoard board = PhotoBoard.builder()
                .title(createBoardModel.title())
                .content(createBoardModel.content())
//                .mainType(MainType.getMainType(createBoardModel.mainType()))
//                .workType(WorkType.getWorkType(createBoardModel.workType()))
                .readCount(0)
                .deleteYn(false)
                .user(user)
                .build();

        return photoBoardRepository.save(board);
    }

    @Override
    public Integer updateBoard(UpdatePhotoBoardModel updatePhotoBoardModel, String token) {

        PhotoBoard board = validateBoard(updatePhotoBoardModel.boardId(), token);

        board.updateTitle(updatePhotoBoardModel.title());
        board.updateContent(updatePhotoBoardModel.content());
        board.updateDate(); // 수정날짜 업데이트

        return board.getId();
    }

    @Override
    public void deleteBoard(Integer boardId, String token) {

        validateBoard(boardId, token);
        photoBoardRepository.deleteBoard(boardId);
    }

    private PhotoBoard validateBoard(Integer boardId, String token) {

        User user = getUser(token);
        PhotoBoard board = photoBoardRepository.findBoardDetail(boardId).orElseThrow(() -> new CustomException(ExceptionType.BOARD_NOT_FOUND));

        if (user.getRole() != Role.ADMIN && !board.getUser().equals(user)) {
            throw new CustomException(ExceptionType.NOT_BOARD_USER);
        }
        return board;
    }

    private User getUser(String token) {
        String email = jwtTokenProvider.getUserSubject(token); //토큰에서 유저 email 가져오기
        return userRepository.findUser(email).orElseThrow(() -> new CustomException(ExceptionType.USER_NOT_FOUND)); // email로 user 조회
    }
}
