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
    @Column(name = "contract_id")
    private Integer id;

    //외래키
    @Column(name = "user_id")
    private Integer userId;

    //외래키
    //private Integer work_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_id")
    private Work work;

    @ColumnDefault("0") //대기0, 진행1, 정지9, 완료10
    @Column(name = "work_progress")
    private int workProgress;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Builder

    public Contract(Integer userId, Work work, int workProgress, LocalDateTime startDate, LocalDateTime endDate) {
        this.userId = userId;
        this.work = work;
        this.workProgress = workProgress;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
