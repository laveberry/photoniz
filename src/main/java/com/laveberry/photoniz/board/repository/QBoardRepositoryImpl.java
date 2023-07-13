package com.laveberry.photoniz.board.repository;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.domain.QBoard;
import com.laveberry.photoniz.board.enums.BoardType;
import com.laveberry.photoniz.photoBoard.enums.MainType;
import com.laveberry.photoniz.work.enums.WorkType;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class QBoardRepositoryImpl implements QBoardRepository {

    private final JPAQueryFactory jpaQueryFactory;

    private final QBoard board = QBoard.board;

    @Override
    public void softDelete(Integer boardId) {
        jpaQueryFactory.update(board)
                .set(board.deleteYn, true)
                .where(board.id.eq(boardId))
                .execute();
    }

    @Override
    public Page<Board> findBoardListByTypes(BoardType type, MainType mainType, WorkType workType, Pageable pageable) {
        List<Board> boardList = jpaQueryFactory.selectFrom(board)
                .from(board)
                .where(board.type.eq(type),
                        mainTypeExist(mainType),
                        workTypeExist(workType),
                        board.deleteYn.isFalse())
                .orderBy(boardSort(pageable))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();


        Long count = jpaQueryFactory.select(board.count())
                .from(board)
                .where(board.type.eq(type),
                        mainTypeExist(mainType),
                        board.deleteYn.isFalse())
                .fetchOne();

        return new PageImpl<>(boardList, pageable, count);
    }

    private BooleanExpression mainTypeExist(MainType mainType) {
        if (Objects.nonNull(mainType) && mainType != MainType.ALL) {
            return board.mainType.eq(mainType);
        } else {
            return null;
        }
    }

    private BooleanExpression workTypeExist(WorkType workType){
        if(Objects.nonNull(workType) && workType != WorkType.ALL){
            return board.workType.eq(workType);
        } else {
            return null;
        }
    }

    private OrderSpecifier<?> boardSort(Pageable pageable) {
        if (!pageable.getSort().isEmpty()) {
            for (Sort.Order order : pageable.getSort()) {
                Order direction = order.getDirection().isAscending() ? Order.ASC : Order.DESC;
                switch (order.getProperty()) {
                    case "id" -> {
                        return new OrderSpecifier<>(direction, board.id);
                    }
                }
            }
        }
        return null;
    }
}
