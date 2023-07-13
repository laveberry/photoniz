package com.laveberry.photoniz.work.enums;

import com.laveberry.photoniz.exception.CustomException;
import com.laveberry.photoniz.exception.ExceptionType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public enum WorkType {

    ALL("ALL"),
    WEDDING("WEDDING"),
    BODY("BODY"),
    PERSONAL("PERSONAL");

    private final String value;

    public static WorkType getWorkType(String type){
        return Arrays.stream(WorkType.values())
                .filter(workType -> Objects.equals(type, workType.value))
                .findFirst().orElseThrow(() -> new CustomException(ExceptionType.INCORRECT_WORK_TYPE));
    }
}
