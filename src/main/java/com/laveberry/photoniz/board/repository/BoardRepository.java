package com.laveberry.photoniz.board.repository;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.enums.BoardType;
import com.laveberry.photoniz.photoBoard.enums.MainType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BoardRepository {
    Optional<Board> findBoardDetail(Integer boardId);

    Page<Board> findBoardList(BoardType type, MainType mainType, Pageable pageable);

    Board save(Board board);

    void deleteBoard(Integer boardId);
}
