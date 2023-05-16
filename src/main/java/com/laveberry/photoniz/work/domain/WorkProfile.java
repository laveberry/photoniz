package com.laveberry.photoniz.work.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class WorkProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int work_profile_id;

    @Column(nullable = false)
    private int author_id; //작가아이디

    private String location; //장소

    private LocalDateTime work_time; //작업시간

    @ColumnDefault("0")
    private double price; //가격

    @ColumnDefault("0")
    private Integer discount;//할인율

    private Integer work_type; //작업유형

    @ColumnDefault("N")
    private String use_yn; //사용여부

    @Builder
    public WorkProfile(int author_id, String location, LocalDateTime work_time, double price, Integer discount, Integer work_type, String use_yn) {
        this.author_id = author_id;
        this.location = location;
        this.work_time = work_time;
        this.price = price;
        this.discount = discount;
        this.work_type = work_type;
        this.use_yn = use_yn;
    }
}
