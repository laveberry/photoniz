package com.laveberry.photoniz.photo.enums;

import com.laveberry.photoniz.exception.CustomException;
import com.laveberry.photoniz.exception.ExceptionType;
import com.laveberry.photoniz.common.enums.MainType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@AllArgsConstructor
@Getter
public enum PhotoType {
    MAIN("MAIN"),
    AD("AD"),
    REAL("REAL");

    private final String name;

    public static PhotoType getPhotoType(String type) {
        return Arrays.stream(PhotoType.values())
                .filter(photoType -> Objects.equals(type, photoType))
                .findFirst().orElseThrow(() -> new CustomException(ExceptionType.INCORRECT_MAIN_TYPE));
    }
}
