package com.laveberry.photoniz.board.repository;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.enums.BoardType;
import com.laveberry.photoniz.common.enums.MainType;
import com.laveberry.photoniz.work.enums.WorkType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QBoardRepository {

    void softDelete(Integer boardId);

    Page<Board> findBoardListByTypes(BoardType type, MainType mainType, WorkType workType, Pageable pageable);
}
