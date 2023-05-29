package com.laveberry.photoniz.user.model;

import com.laveberry.photoniz.user.domain.Address;
import lombok.Builder;

@Builder
public record CreateUserModel(String email, String password, String name, String phone, Address address) {
}
