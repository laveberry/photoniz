package com.laveberry.photoniz.chat.repository;

import com.laveberry.photoniz.chat.domain.QChat;
import com.laveberry.photoniz.chat.domain.QChatFile;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class QChatFileRepositoryImpl implements QChatFileRepository{

    private final JPAQueryFactory jpaQueryFactory;

    private final QChatFile chatFile = QChatFile.chatFile;

    private final QChat chat = QChat.chat;

    @Override
    public void updateDeletedAt(Long userId, Long fileId) {
        jpaQueryFactory.update(chatFile)
                .set(chatFile.deletedAt, LocalDateTime.now()
//                ).where(chatFile.in(jpaQueryFactory.select(chat.chatFile).from(chat))
                ).execute();
    }

    @Override
    public void delete() {
        log.info("쿼리시작");
        jpaQueryFactory.delete(chatFile)
                .where(chatFile.deletedAt.isNotNull())
                .execute();
        log.info("쿼리종료");
    }


}
