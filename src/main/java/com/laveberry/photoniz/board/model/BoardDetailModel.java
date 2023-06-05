package com.laveberry.photoniz.board.model;

import com.laveberry.photoniz.board.enums.BoardType;

import java.time.LocalDateTime;

public record BoardDetailModel(Integer boardId, BoardUserModel user, String title, String content, Integer readCount,
                               LocalDateTime createdAt, LocalDateTime updatedAt, BoardType type) {
}
