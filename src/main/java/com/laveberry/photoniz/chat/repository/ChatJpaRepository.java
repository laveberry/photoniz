package com.laveberry.photoniz.chat.repository;

import com.laveberry.photoniz.chat.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatJpaRepository extends JpaRepository<Chat, Long> {
}
