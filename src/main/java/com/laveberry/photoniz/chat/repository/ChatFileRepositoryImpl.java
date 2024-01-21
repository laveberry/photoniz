package com.laveberry.photoniz.chat.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatFileRepositoryImpl implements ChatFileRepository{

    private final QChatFileRepository qChatFileRepository;

    @Override
    public void updateDeletedAt(Long userId, Long fileId) {
        qChatFileRepository.updateDeletedAt(userId, fileId);
    }
}
