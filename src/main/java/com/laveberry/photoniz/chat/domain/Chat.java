package com.laveberry.photoniz.chat.domain;


import com.laveberry.photoniz.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@AllArgsConstructor
public class Chat extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long id;

    private String message;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private ChatRoom chatRoom;

    //메세지 삭제될때 ChatFile도 삭제, 그전에 ChatFile 삭제마킹 처리
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private ChatFile chatFile;
}
