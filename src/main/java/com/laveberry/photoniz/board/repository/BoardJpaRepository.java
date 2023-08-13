package com.laveberry.photoniz.board.repository;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.enums.BoardType;
import com.laveberry.photoniz.common.enums.MainType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardJpaRepository extends JpaRepository<Board, Integer> {
    Page<Board> findByTypeAndMainTypeAndDeleteYnIsFalseOrderById(BoardType type, MainType mainType, Pageable pageable);

    Optional<Board> findByIdAndDeleteYnIsFalse(Integer id);
}
