package com.laveberry.photoniz.user.model;

import com.laveberry.photoniz.user.domain.Address;
import jakarta.validation.constraints.NotNull;

public record UpdateUserModel(@NotNull String nickName, String password, String phone, Address address) {
}
