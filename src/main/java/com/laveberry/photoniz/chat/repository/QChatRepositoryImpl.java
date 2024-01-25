package com.laveberry.photoniz.chat.repository;

import com.laveberry.photoniz.chat.domain.ChatFile;
import com.laveberry.photoniz.chat.domain.QChat;
import com.laveberry.photoniz.chat.domain.QChatFile;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Slf4j
@Repository
@RequiredArgsConstructor
public class QChatRepositoryImpl implements QChatRepository{

    private final JPAQueryFactory jpaQueryFactory;

    private final QChat chat = QChat.chat;



    @Override
    public void updateMaking() {
        jpaQueryFactory.update(chat)
                .set(chat.chatFile, (ChatFile) null)
                .execute();
    }
}
