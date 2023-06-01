package com.laveberry.photoniz.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    //기본주소
    @Column(name = "base_address")
    private String baseAddress;

    //상세주소
    @Column(name = "detail_address")
    private String detailAddress;

    //우편번호
    @Column(name = "zip_code")
    private String zipCode;

}
