package com.laveberry.photoniz.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    ADMIN("ADMIN"),
    PHOTOGRAPHER("PHOTOGRAPHER"),
    MODEL("MODEL"),
    USER("USER");

    private final String name;
}
