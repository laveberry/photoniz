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

    private Integer author_id; //작가아이디
    private String work_type; //작업유형
    private double price; //가격
    private String location;

    @Builder
    public WorkSaveRequestDto(Integer author_id, String work_type, double price, String location) {
        this.author_id = author_id;
        this.work_type = work_type;
        this.price = price;
        this.location = location;
    }

    public Work toEntity(){
        return Work.builder()
                .author_id(author_id)
                .work_type(work_type)
                .price(price)
                .location(location)
                .build();
    }
}
