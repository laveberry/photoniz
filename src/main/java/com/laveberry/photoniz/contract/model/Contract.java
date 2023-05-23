package com.laveberry.photoniz.contract.model;

import com.laveberry.photoniz.common.BaseTimeEntity;
import com.laveberry.photoniz.work.domain.Work;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

/**
 * 계약 테이블
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Contract extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contract_id;

    //외래키
    private Integer user_id;

    //외래키
    //private Integer work_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WORK_ID")
    private Work work;

    @ColumnDefault("0") //대기0, 진행1, 정지9, 완료10
    private int work_progress;

    private LocalDateTime start_date;

    private LocalDateTime end_date;

    @Builder

    public Contract(Integer user_id, Work work, int work_progress, LocalDateTime start_date, LocalDateTime end_date) {
        this.user_id = user_id;
        this.work = work;
        this.work_progress = work_progress;
        this.start_date = start_date;
        this.end_date = end_date;
    }
}
