package com.laveberry.photoniz.user.model;

import jakarta.validation.constraints.NotNull;

public record SignUpUserModel(@NotNull String email, @NotNull String name, @NotNull String password, String phone,
                              String address) {
}
