package com.laveberry.photoniz.user.repository;

import com.laveberry.photoniz.user.domain.QUser;
import com.laveberry.photoniz.user.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QUserRepositoryImpl implements QUserRepository {

    private final JPAQueryFactory jpaQueryFactory;

    private final QUser user = QUser.user;

    @Override
    public List<User> findUserByName(String name) {
        return jpaQueryFactory.selectFrom(user)
                .where(user.name.eq(name))
                .fetch();

    }
}
