package com.laveberry.photoniz.chat.repository;

import com.laveberry.photoniz.chat.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ChatJpaRepository extends JpaRepository<Chat, Long> {

    @Query("select c.chatFile.id from Chat c")
    List<Long> findChatChatFileId();

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Chat m SET m.message = 'DELETEDFILE', m.chatFile = null WHERE m.chatFile IS NOT NULL")
    void updateOlderThan();


}
