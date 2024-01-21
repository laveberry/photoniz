package com.laveberry.photoniz.chat.controller;

import com.laveberry.photoniz.chat.domain.ChatFile;
import com.laveberry.photoniz.chat.model.ChatFileModel;
import com.laveberry.photoniz.chat.service.ChatService;
import com.laveberry.photoniz.common.model.BasicResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/chat")
public class ChatController {

    private final ChatService chatService;

    @Operation(summary = "채팅 파일 전송", description = "채팅 파일 업로드 전송 합니다", tags = {"Chat Controller"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = BasicResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR"),
    })
    public BasicResponse fileUpload(@RequestParam Long userId, @RequestPart(value = "file", required = false) MultipartFile file) {
        log.info("chat file upload. name ={}, size ={}", file.getOriginalFilename(), file.getSize());
        ChatFile chatFile = chatService.upload(userId, file);
        return BasicResponse.toResponse(HttpStatus.OK, chatFile.getId());
    }
}
