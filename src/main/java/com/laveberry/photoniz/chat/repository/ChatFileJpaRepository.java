package com.laveberry.photoniz.chat.repository;

import com.laveberry.photoniz.chat.domain.ChatFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ChatFileJpaRepository extends JpaRepository<ChatFile, Long> {

    @Modifying
    @Query("UPDATE ChatFile SET deletedAt = current_date() WHERE id in (select chatFile.id from Chat)")
    void markChatMessageAttachDeletedAtOlderThan();


    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM ChatFile WHERE deletedAt IS NOT NULL")
    void deleteOldChatMessageAttach();
}
