package com.laveberry.photoniz.work.domain;

import com.laveberry.photoniz.common.BaseTimeEntity;
import com.laveberry.photoniz.contract.model.Contract;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Work extends BaseTimeEntity { //db매칭
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer work_id; //작업아이디

    @Column(nullable = false)
    private Integer author_id; //작가아이디

    @Column(length = 100)
    private String work_type; //작업유형

    private double price; //가격

    @Column(length = 100)
    private String location; //지역? 작업위치?

    @OneToMany(mappedBy = "work")
    private List<Contract> contracts = new ArrayList<>();

    @Builder
    public Work(Integer author_id, String work_type, double price, String location) {
        this.author_id = author_id;
        this.work_type = work_type;
        this.price = price;
        this.location = location;
    }

    public void addContract(final Contract contract){
        contracts.add(contract);
        contract.setWork(this);
    }
}
