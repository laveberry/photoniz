package com.laveberry.photoniz.photoBoard.domain;

import com.laveberry.photoniz.common.BaseTimeEntity;
import com.laveberry.photoniz.photoBoard.enums.MainType;
import com.laveberry.photoniz.user.domain.User;
import com.laveberry.photoniz.work.enums.WorkType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotoBoard extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Integer id;

    private String title;

    private String content;

    @Column(name = "read_count")
    private Integer readCount;

    //이거 수정
    @Enumerated(EnumType.STRING)
    @Column(name = "main_type")
    private MainType type;

    @Enumerated(EnumType.STRING)
    private WorkType workType;

    private Integer mainPhotoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "delete_yn", columnDefinition = "tinyint(1)")
    private Boolean deleteYn;

    public void updateTitle(String title) {
        if (Objects.nonNull(title)) {
            this.title = title;
        }
    }

    public void updateContent(String content) {
        if (Objects.nonNull(content)) {
            this.content = content;
        }
    }

}
