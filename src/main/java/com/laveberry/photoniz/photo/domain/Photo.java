package com.laveberry.photoniz.photo.domain;

import com.laveberry.photoniz.common.BaseTimeEntity;
import com.laveberry.photoniz.photo.enums.PhotoType;
import com.laveberry.photoniz.user.domain.User;
import com.laveberry.photoniz.work.domain.Work;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Photo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "photo_name")
    private String photoName;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "photo_size")
    private Long photoSize;

    @Column(name = "photo_type")
    @Enumerated(EnumType.STRING)
    private PhotoType photoType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_id")
    private Work work;

}
