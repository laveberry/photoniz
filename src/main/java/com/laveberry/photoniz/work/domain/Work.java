package com.laveberry.photoniz.work.domain;

import com.laveberry.photoniz.common.BaseTimeEntity;
import com.laveberry.photoniz.contract.model.Contract;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Work extends BaseTimeEntity { //db매칭
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_id")
    private Integer id; //작업아이디

    @Column(nullable = false)
    private Integer authorId; //작가아이디

    @Column(name = "work_type")
    private String workType; //작업유형

    private Integer price; //가격

    private String location; //지역? 작업위치?

    //영속성, 고아객체
    @OneToMany(mappedBy = "work", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Contract> contracts = new ArrayList<>();

    @Builder
    public Work(Integer authorId, String workType, Integer price, String location) {
        this.authorId = authorId;
        this.workType = workType;
        this.price = price;
        this.location = location;
    }

    public void addContract(final Contract contract) {
        contracts.add(contract);
        contract.setWork(this);
    }
}
