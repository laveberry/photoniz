package com.laveberry.photoniz.chat.repository;

import com.laveberry.photoniz.chat.domain.ChatFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatFileJpaRepository extends JpaRepository<ChatFile, Long> {
}
