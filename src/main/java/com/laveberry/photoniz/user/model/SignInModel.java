package com.laveberry.photoniz.user.model;

import jakarta.validation.constraints.NotNull;

public record SignInModel(@NotNull String email, @NotNull String password) {
}
