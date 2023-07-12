package com.laveberry.photoniz.board.repository;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.enums.BoardType;
import com.laveberry.photoniz.photoBoard.enums.MainType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QBoardRepository {

    void softDelete(Integer boardId);

    Page<Board> findBoardListByTypes(BoardType type, MainType mainType, Pageable pageable);
}
