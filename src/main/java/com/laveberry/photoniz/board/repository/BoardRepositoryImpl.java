package com.laveberry.photoniz.board.repository;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.enums.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {

    private final BoardJpaRepository boardJpaRepository;
    private final QBoardRepository qBoardRepository;

    @Override
    public Optional<Board> findBoardDetail(Integer boardId) {
        return boardJpaRepository.findByIdAndDeleteYnIsFalse(boardId);
    }

    @Override
    public Page<Board> findBoardList(BoardType type, Pageable pageable) {
        return boardJpaRepository.findByTypeAndDeleteYnIsFalseOrderById(type, pageable);
    }

    @Override
    public Board save(Board board) {
        return boardJpaRepository.save(board);
    }

    @Override
    public void deleteBoard(Integer boardId) {
        qBoardRepository.softDelete(boardId);
    }
}
