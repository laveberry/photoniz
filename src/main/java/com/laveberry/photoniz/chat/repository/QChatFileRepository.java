package com.laveberry.photoniz.chat.repository;

public interface QChatFileRepository {
    void updateDeletedAt(Long userId, Long fileId);

    void delete();
}
