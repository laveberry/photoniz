package com.laveberry.photoniz.common.enums;

import com.laveberry.photoniz.exception.CustomException;
import com.laveberry.photoniz.exception.ExceptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum MainType {

    ALL("ALL"),
    PHOTO("PHOTO"),
    AUTHOR("AUTHOR"),
    MODEL("MODEL"),
    EDIT("EDIT"),
    PAINTING("PAINTING");

    private final String type;

    public static MainType getMainType(String type) {
        return Arrays.stream(MainType.values())
                .filter(mainType -> Objects.equals(type, mainType.type))
                .findFirst().orElseThrow(() -> new CustomException(ExceptionType.INCORRECT_MAIN_TYPE));
    }
}
