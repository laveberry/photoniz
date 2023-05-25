package com.laveberry.photoniz.user.domain;

import lombok.Builder;

@Builder
public record CreateUserModel(String email, String password, String name, String phone, String address) {
}
