package com.laveberry.photoniz.board.repository;

import com.laveberry.photoniz.board.domain.Board;

import java.util.Optional;

public interface BoardRepository {
    Optional<Board> findBoardDetail(Integer boardId);
}
