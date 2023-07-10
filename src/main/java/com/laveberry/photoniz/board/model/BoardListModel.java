package com.laveberry.photoniz.board.model;

import com.laveberry.photoniz.board.enums.BoardType;
import com.laveberry.photoniz.photoBoard.enums.MainType;

import java.time.LocalDateTime;

public record BoardListModel(Integer boardId, String nickName, String title, Integer readCount,
                             LocalDateTime createdAt, LocalDateTime updatedAt, BoardType type, MainType mainType) {

}
