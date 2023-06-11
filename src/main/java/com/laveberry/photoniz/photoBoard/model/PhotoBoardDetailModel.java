package com.laveberry.photoniz.photoBoard.model;

import com.laveberry.photoniz.photoBoard.enums.MainType;
import com.laveberry.photoniz.work.enums.WorkType;

import java.time.LocalDateTime;

public record PhotoBoardDetailModel(Integer boardId, BoardUserModel user, String title, String content, Integer readCount,
                                    LocalDateTime createdAt, LocalDateTime updatedAt, WorkType workType, MainType mainType) {
}
