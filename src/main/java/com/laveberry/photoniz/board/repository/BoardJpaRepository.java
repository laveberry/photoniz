package com.laveberry.photoniz.board.repository;

import com.laveberry.photoniz.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardJpaRepository extends JpaRepository<Board, Integer> {
}
