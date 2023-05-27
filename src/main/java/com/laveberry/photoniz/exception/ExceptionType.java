package com.laveberry.photoniz.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@RequiredArgsConstructor
public enum ExceptionType {

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U1000", "유저가 존재하지 않습니다."),
    SIGN_IN_FAILED(HttpStatus.BAD_REQUEST, "U1001", "로그인 정보가 잘못되었습니다.");

    private final HttpStatus status;
    private final String errorCode;
    private final String message;
}
