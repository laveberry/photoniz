package com.laveberry.photoniz.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    //엔티티 생성되어 저장시 시간 자동저장
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime modifiedDate;

    public void updateDate() {
        this.modifiedDate = LocalDateTime.now();
    }
}
