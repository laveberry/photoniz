package com.laveberry.photoniz.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class ErrorResponse {
    private final int statusCode;
    private final String status;
    private final String errorCode;
    private final String message;

    public static ResponseEntity<ErrorResponse> toResponseEntity(ExceptionType exceptionType) {
        return ResponseEntity
                .status(exceptionType.getStatus())
                .body(ErrorResponse.builder()
                        .statusCode(exceptionType.getStatus().value())
                        .status(exceptionType.name())
                        .errorCode(exceptionType.getErrorCode())
                        .message(exceptionType.getMessage())
                        .build());
    }
}
