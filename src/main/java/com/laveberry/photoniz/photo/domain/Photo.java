package com.laveberry.photoniz.photo.domain;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.common.BaseTimeEntity;
import com.laveberry.photoniz.photo.enums.PhotoType;
import com.laveberry.photoniz.photoBoard.enums.MainType;
import com.laveberry.photoniz.user.domain.User;
import com.laveberry.photoniz.work.domain.Work;
import com.laveberry.photoniz.work.enums.WorkType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Photo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private Integer id;

    @Column(name = "photo_name")
    private String photoName;

    @Column(name = "photo_origin_name")
    private String photoOriginName;

    private String ext; // 확장자

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "photo_size")
    private Long photoSize;

    @Column(name = "photo_type")
    @Enumerated(EnumType.STRING)
    private PhotoType photoType;

//    @Column(name = "main_type")
//    @Enumerated(EnumType.STRING)
//    private MainType mainType;
//
//    @Column(name = "work_type")
//    @Enumerated(EnumType.STRING)
//    private WorkType workType;
//
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User writer;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_id")
    private Work work;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;



}
