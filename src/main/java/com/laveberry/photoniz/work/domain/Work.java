package com.laveberry.photoniz.work.domain;

import com.laveberry.photoniz.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Work extends BaseTimeEntity { //db매칭
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer work_id; //작업아이디

    @Column(nullable = false)
    private Integer work_profile_id; //매칭 작업프로필

    @Column(nullable = false)
    private Integer author_id; //작가아이디

    @Column(nullable = false)
    private Integer customer_id; //고객아이디

    @Column(nullable = false)
    private Integer work_state; //진행상태

    private Integer work_flag; //작업유형

    private LocalDateTime work_time; //작업일자

    private double price; //가격

    @Column(length = 100)
    private String location; //지역? 작업위치?

    @Builder
    public Work(int work_profile_id, int author_id, int customer_id, int work_state, int work_flag, double price, String location) {
        this.work_profile_id = work_profile_id;
        this.author_id = author_id;
        this.customer_id = customer_id;
        this.work_state = work_state;
        this.work_flag = work_flag;
        this.price = price;
        this.location = location;
    }
}
