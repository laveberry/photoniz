package com.laveberry.photoniz.photo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PhotoType {
    MAIN("MAIN"),
    AD("AD"),
    REAL("REAL");

    private final String name;

}
