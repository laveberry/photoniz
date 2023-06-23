package com.laveberry.photoniz.photoBoard.model;

import com.laveberry.photoniz.photoBoard.enums.MainType;
import com.laveberry.photoniz.work.enums.WorkType;

import java.time.LocalDateTime;

public record PhotoBoardListModel(Integer boardId, String nickName, String title, Integer readCount,
                                  LocalDateTime createdAt, LocalDateTime updatedAt, MainType type, WorkType workType) {

}
