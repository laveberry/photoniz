package com.laveberry.photoniz.work.dto;

import com.laveberry.photoniz.contract.model.Contract;
import com.laveberry.photoniz.work.domain.Work;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class WorkSaveRequestDto {

    private Integer authorId; //작가아이디
    private String workType; //작업유형
    private double price; //가격
    private String location;

    @Builder
    public WorkSaveRequestDto(Integer authorId, String workType, double price, String location) {
        this.authorId = authorId;
        this.workType = workType;
        this.price = price;
        this.location = location;
    }

    public Work toEntity(){
        return Work.builder()
                .authorId(authorId)
                .workType(workType)
                .price(price)
                .location(location)
                .build();
    }
}
