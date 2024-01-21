package com.laveberry.photoniz.chat.service;

import com.laveberry.photoniz.chat.domain.ChatFile;
import org.springframework.web.multipart.MultipartFile;

public interface ChatService {

    ChatFile upload(Long userId, MultipartFile file);
}
