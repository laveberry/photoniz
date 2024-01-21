package com.laveberry.photoniz.chat.service;

import com.laveberry.photoniz.chat.domain.Chat;
import com.laveberry.photoniz.chat.domain.ChatFile;
import com.laveberry.photoniz.chat.model.ChatFileModel;
import com.laveberry.photoniz.chat.repository.ChatFileJpaRepository;
import com.laveberry.photoniz.chat.repository.ChatJpaRepository;
import com.laveberry.photoniz.chat.repository.QChatFileRepository;
import com.laveberry.photoniz.common.BaseSpringBootTest;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("채팅 서비스")
class ChatServiceTest extends BaseSpringBootTest {

    @Autowired
    private ChatService chatService;

    @Autowired
    private ChatFileJpaRepository chatFileJpaRepository;

    @Autowired
    private ChatJpaRepository chatJpaRepository;

    @Autowired
    private QChatFileRepository qChatFileRepository;

    @Autowired
    private EntityManager entityManager;


    @Test
    @DisplayName("채팅파일_등록_실패케이스_OneToOne_fk_확인")
    @Transactional
    void uploadChatFile() {
        ChatFile chatFile = ChatFile.builder()
                .hostId(1L)
                .fineName("테스트 채팅파일")
                .build();

        chatFileJpaRepository.save(chatFile);

        //OneToOne속성 영향도 확인
        Chat chat1 = Chat.builder()
                .chatFile(chatFile)
                .build();
        Chat chat2 = Chat.builder()
                .chatFile(chatFile)
                .build();

        chatJpaRepository.save(chat1);
        chatJpaRepository.save(chat2);

        List<Chat> chats = chatJpaRepository.findAll();
        assertThat(chats).hasSize(2);

        qChatFileRepository.updateDeletedAt(1L, chatFile.getId());

        entityManager.flush();
        entityManager.clear();

        List<ChatFile> all = chatFileJpaRepository.findAll();

        for (ChatFile file : all) {
            System.out.println("삭제일자" + file.getDeletedAt());
        }

        //삭제 실패해야함
        qChatFileRepository.delete();

        entityManager.flush();
        entityManager.clear();

        assertThat(chatFileJpaRepository.count()).isEqualTo(0);
    }

}