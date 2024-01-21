package com.laveberry.photoniz.chat.domain;

import com.laveberry.photoniz.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_file_id")
    private Long id;

//    private String originName;

    private String fineName;

    private String filePath;

    private Long fileSize;

//    private String extension;
//    private String fileType;

    private Long hostId;

    private LocalDateTime deletedAt;

}
