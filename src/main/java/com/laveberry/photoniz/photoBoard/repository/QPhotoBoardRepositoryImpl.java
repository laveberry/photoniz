package com.laveberry.photoniz.photoBoard.repository;

import com.laveberry.photoniz.board.domain.QBoard;
import com.laveberry.photoniz.photoBoard.domain.QPhotoBoard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QPhotoBoardRepositoryImpl implements QPhotoBoardRepository {

    private final JPAQueryFactory jpaQueryFactory;

    private final QPhotoBoard photoBoard = QPhotoBoard.photoBoard;

    @Override
    public void softDelete(Integer boardId) {
        jpaQueryFactory.update(photoBoard)
                .set(photoBoard.deleteYn, true)
                .where(photoBoard.id.eq(boardId))
                .execute();
    }
}
