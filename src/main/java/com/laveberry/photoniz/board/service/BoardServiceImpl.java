package com.laveberry.photoniz.board.service;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.enums.BoardType;
import com.laveberry.photoniz.board.model.*;
import com.laveberry.photoniz.board.repository.BoardRepository;
import com.laveberry.photoniz.common.util.FileUploader;
import com.laveberry.photoniz.config.jwt.JwtTokenProvider;
import com.laveberry.photoniz.exception.CustomException;
import com.laveberry.photoniz.exception.ExceptionType;
import com.laveberry.photoniz.files.domain.Files;
import com.laveberry.photoniz.photo.domain.Photo;
import com.laveberry.photoniz.photo.enums.PhotoType;
import com.laveberry.photoniz.photoBoard.enums.MainType;
import com.laveberry.photoniz.user.domain.User;
import com.laveberry.photoniz.user.enums.Role;
import com.laveberry.photoniz.user.repository.UserRepository;
import com.laveberry.photoniz.work.enums.WorkType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    private final FileUploader fileUploader;

    @Override
    public BoardDetailModel findBoardDetail(Integer boardId) {

        Board board = boardRepository.findBoardDetail(boardId).orElseThrow(
                () -> new CustomException(ExceptionType.BOARD_NOT_FOUND));

        BoardUserModel boardUserModel = new BoardUserModel(
                board.getUser().getNickName(),
                board.getUser().getEmail()
        );

        return new BoardDetailModel(board.getId(), boardUserModel, board.getTitle(), board.getContent(),
                board.getReadCount(), board.getCreateDate(), board.getModifiedDate(), board.getType());
    }


    @Override
    public Page<BoardListModel> findBoardList(String type, String mainType, String workType, Pageable pageable) {

        //TODO 페이지 관련 추가 처리 필요
        return boardRepository.findBoardList(BoardType.getType(type), MainType.getMainType(mainType), WorkType.getWorkType(workType), pageable).map(board ->
                new BoardListModel(board.getId(), board.getUser().getNickName(), board.getTitle(),
                        board.getReadCount(), board.getCreateDate(), board.getModifiedDate(), board.getType(), board.getMainType(), board.getWorkType()));
    }

    @Override
    public Board createBoard(CreateBoardModel createBoardModel, String token) {

        User user = getUser(token);

        Board board = Board.builder()
                .title(createBoardModel.title())
                .content(createBoardModel.content())
                .type(BoardType.getType(createBoardModel.type()))
                .workType(WorkType.getWorkType(createBoardModel.workType()))
                .readCount(0)
                .deleteYn(false)
                .user(user)
                .build();


        //이미지 업로드
        if(!createBoardModel.multipartFile().isEmpty()){

            // 리팩토링 필요
            for(MultipartFile file : createBoardModel.multipartFile()){
                // 변경 파일이름으로 서버 저장
                int dot = file.getName().lastIndexOf(".");
                String ext = (file.getName().toLowerCase()).substring(dot, file.getName().length());
                String reFileName = LocalDateTime.now() + "." + ext;

                log.info("orgin = {}, rename = {}" , file.getName(), reFileName);

                Map<String, String> upload = fileUploader.upload(reFileName, file);

                if(upload.get("result").equals("OK")){
                    Photo photo = Photo.builder()
                            .photoName(reFileName)
                            .photoOriginName(file.getOriginalFilename())
                            .ext(ext)
                            .photoUrl(upload.get("path"))
                            .photoSize(file.getSize())
                            .board(board)
                            .build();
                }
            }
        }

        return boardRepository.save(board);
    }

    @Override
    public Integer updateBoard(UpdateBoardModel updateBoardModel, String token) {

        Board board = validateBoard(updateBoardModel.boardId(), token);

        board.updateTitle(updateBoardModel.title());
        board.updateContent(updateBoardModel.content());
        board.updateDate(); // 수정날짜 업데이트

        return board.getId();
    }

    @Override
    public void deleteBoard(Integer boardId, String token) {

        validateBoard(boardId, token);
        boardRepository.deleteBoard(boardId);
    }

    private Board validateBoard(Integer boardId, String token) {

        User user = getUser(token);
        Board board = boardRepository.findBoardDetail(boardId).orElseThrow(() -> new CustomException(ExceptionType.BOARD_NOT_FOUND));

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
