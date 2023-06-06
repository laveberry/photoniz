package com.laveberry.photoniz.board.service;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.enums.BoardType;
import com.laveberry.photoniz.board.model.BoardDetailModel;
import com.laveberry.photoniz.board.model.BoardListModel;
import com.laveberry.photoniz.board.model.BoardUserModel;
import com.laveberry.photoniz.board.repository.BoardRepository;
import com.laveberry.photoniz.exception.CustomException;
import com.laveberry.photoniz.exception.ExceptionType;
import com.laveberry.photoniz.user.domain.User;
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
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public BoardDetailModel findBoardDetail(Integer boardId) {

        Board board = boardRepository.findBoardDetail(boardId).orElseThrow(
                () -> new CustomException(ExceptionType.BOARD_NOT_FOUND));

        User user = board.getUser();

        BoardUserModel boardUserModel = new BoardUserModel(
                user.getNickName(),
                user.getEmail()
        );

        return new BoardDetailModel(board.getId(), boardUserModel, board.getTitle(), board.getContent(),
                board.getReadCount(), board.getCreateDate(), board.getModifiedDate(), board.getType());
    }

    @Override
    public Page<BoardListModel> findBoardList(String type, Pageable pageable) {

        //TODO 페이지 관련 추가 처리 필요
        return boardRepository.findBoardList(BoardType.getType(type), pageable).map(board ->
                new BoardListModel(board.getId(), board.getUser().getNickName(), board.getTitle(),
                        board.getReadCount(), board.getCreateDate(), board.getModifiedDate(), board.getType()));
    }
}
