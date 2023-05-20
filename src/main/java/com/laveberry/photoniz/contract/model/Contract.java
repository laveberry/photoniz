package com.laveberry.photoniz.contract.model;

import com.laveberry.photoniz.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

/**
 계약 테이블
 */
@Getter
@NoArgsConstructor
@Entity
public class Contract extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contract_id;

    //외래키
    private Integer user_id;

    //외래키
    private Integer work_id;

    @ColumnDefault("0") //대기0, 진행1, 정지9, 완료10
    private String work_progress;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private LocalDateTime start_date;

    private LocalDateTime end_date;



}
