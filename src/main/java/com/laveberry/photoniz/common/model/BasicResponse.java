package com.laveberry.photoniz.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@AllArgsConstructor
public class BasicResponse<T> {
    private final int statusCode;
    private final HttpStatus status;
    private final T data;

    public static <T> BasicResponse toResponse(HttpStatus status, T data) {
        return BasicResponse.builder()
                .statusCode(status.value())
                .status(status)
                .data(data)
                .build();
    }


}
