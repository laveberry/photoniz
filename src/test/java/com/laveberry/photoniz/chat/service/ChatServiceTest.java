package com.laveberry.photoniz.chat.service;

import com.laveberry.photoniz.chat.domain.Chat;
import com.laveberry.photoniz.chat.domain.ChatFile;
import com.laveberry.photoniz.chat.model.ChatFileModel;
import com.laveberry.photoniz.chat.repository.ChatFileJpaRepository;
import com.laveberry.photoniz.chat.repository.ChatJpaRepository;
import com.laveberry.photoniz.chat.repository.QChatFileRepository;
import com.laveberry.photoniz.chat.repository.QChatRepository;
import com.laveberry.photoniz.common.BaseSpringBootTest;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    private QChatRepository qChatRepository;

    @Autowired
    private EntityManager entityManager;


    @Test
    @DisplayName("채팅파일_등록_실패케이스_OneToOne_fk_확인")
//    @Transactional
    void uploadChatFile() {
        // Given
        ChatFile chatFile = createChatFile("테스트 채팅파일");

        // OneToOne 관계 확인을 위한 채팅 생성
        Chat chat1 = createChat(chatFile);
        Chat chat2 = createChat(chatFile);

        // When
        chatFileJpaRepository.save(chatFile);
        chatJpaRepository.saveAll(List.of(chat1, chat2));

        // Then
//        List<Chat> chats = chatJpaRepository.findAll();
//        assertThat(chats).hasSize(1);

        //삭제일자 update
        qChatFileRepository.updateDeletedAt(1L, chatFile.getId());
        qChatRepository.updateMaking();

        // 데이터 무결성 위반 오류를 발생시키기 위한 삭제 시도
//        assertThrows(DataIntegrityViolationException.class, () -> {
            qChatFileRepository.delete();
//        });

        // 롤백 후에도 데이터가 남아있어야 함
        assertThat(chatFileJpaRepository.count()).isEqualTo(0);
    }

    private ChatFile createChatFile(String fileName) {
        return ChatFile.builder()
                .hostId(1L)
                .fineName(fileName)
                .build();
    }

    private Chat createChat(ChatFile chatFile) {
        return Chat.builder()
                .chatFile(chatFile)
                .build();
    }

}