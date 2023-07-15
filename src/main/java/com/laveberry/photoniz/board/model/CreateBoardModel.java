package com.laveberry.photoniz.board.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record CreateBoardModel(@NotBlank String title, @NotNull String content, @NotNull String type, String mainType, String workType, List<MultipartFile> multipartFile) {
}
