package com.laveberry.photoniz.chat.service;

import com.laveberry.photoniz.chat.domain.ChatFile;
import com.laveberry.photoniz.chat.model.ChatFileModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ChatServiceImpl implements ChatService {
    @Override
    public ChatFile upload(Long userId, MultipartFile file) {
        try {
            if(!file.isEmpty()){
                InputStream inputStream = file.getInputStream();
                String fileName = file.getOriginalFilename();
            }

            //TODO : 상세추가
            return ChatFile.builder()
                    .hostId(userId)
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
