package com.laveberry.photoniz.user.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    //기본주소
    private String base_Address;
    //우편번호
    private String zip_code;
    //상세주소
    private String detail_address;



}
