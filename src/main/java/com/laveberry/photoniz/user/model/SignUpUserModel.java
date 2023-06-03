package com.laveberry.photoniz.user.model;

import com.laveberry.photoniz.user.domain.Address;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotNull;

public record SignUpUserModel(@NotNull String email, @NotNull String name, @NotNull String nickName, @NotNull String password, String phone, Address address) {
}
