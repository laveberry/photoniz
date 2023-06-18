package com.laveberry.photoniz.board.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateBoardModel(@NotBlank String title, @NotNull String content, @NotNull String type) {
}
