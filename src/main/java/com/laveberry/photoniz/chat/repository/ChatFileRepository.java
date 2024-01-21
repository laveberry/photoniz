package com.laveberry.photoniz.chat.repository;

public interface ChatFileRepository {
    void updateDeletedAt(Long userId, Long fileId);
}
