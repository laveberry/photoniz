package com.laveberry.photoniz.board.repository;

import com.laveberry.photoniz.board.domain.QBoard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QBoardRepositoryImpl implements QBoardRepository{

    private final JPAQueryFactory jpaQueryFactory;

    private final QBoard board = QBoard.board;

    @Override
    public void softDelete(Integer boardId) {
        jpaQueryFactory.update(board)
                .set(board.deleteYn, true)
                .where(board.id.eq(boardId))
                .execute();
    }
}
