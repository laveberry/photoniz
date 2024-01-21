package com.laveberry.photoniz.chat.model;

import java.time.LocalDateTime;

public record ChatFileModel(Integer chatId, String fileName, String filePath, Integer fileSize,
                            Integer hostId, LocalDateTime deletedAt) {
}
