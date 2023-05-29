package com.laveberry.photoniz.user.model;

import com.laveberry.photoniz.user.domain.Address;

public record UserDetailModel(String name, String nickName, String email, String phone, Address address) {
}
