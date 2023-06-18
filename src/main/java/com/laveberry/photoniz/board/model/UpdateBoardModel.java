package com.laveberry.photoniz.board.model;

import jakarta.validation.constraints.NotNull;

public record UpdateBoardModel(@NotNull Integer boardId, String title, String content) {
}
