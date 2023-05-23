package com.laveberry.photoniz.work.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WorkType {

    WEDDING("wedding"),
    BODY("body"),
    PERSONAL("personal");

    private final String value;
}
