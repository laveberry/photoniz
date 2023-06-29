package com.laveberry.photoniz.files.domain;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.common.BaseTimeEntity;
import com.laveberry.photoniz.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Files extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    Integer id;

    @Column(name = "file_name")
    String fileName; //저장파일명

    @Column(name = "file_origin_name")
    String fileOriginName; //원본파일명

    @Column(name = "file_size")
    Integer fileSize;

    @Column(name = "is_image")
    Boolean isImage; // 이미지 여부

    String fileType; // 확장자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

}
