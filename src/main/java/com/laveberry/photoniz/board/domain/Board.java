package com.laveberry.photoniz.board.domain;

import com.laveberry.photoniz.board.enums.BoardType;
import com.laveberry.photoniz.common.BaseTimeEntity;
import com.laveberry.photoniz.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Integer id;

    private String title;

    private String content;

    @Column(name = "read_count")
    private Integer readCount;

    @Enumerated(EnumType.STRING)
    private BoardType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "delete_yn", columnDefinition = "tinyint(1)")
    private Boolean deleteYn;

}
