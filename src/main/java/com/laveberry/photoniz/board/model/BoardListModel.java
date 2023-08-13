package com.laveberry.photoniz.board.model;

import com.laveberry.photoniz.board.enums.BoardType;
import com.laveberry.photoniz.common.enums.MainType;
import com.laveberry.photoniz.work.enums.WorkType;

import java.time.LocalDateTime;

public record BoardListModel(Integer boardId, String nickName, String title, Integer readCount,
                             LocalDateTime createdAt, LocalDateTime updatedAt, BoardType type, MainType mainType, WorkType workType) {

}
