package com.laveberry.photoniz.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    ADMIN("admin"),
    PHOTOGRAPHER("photographer"),
    USER("user");

    private final String name;
}
