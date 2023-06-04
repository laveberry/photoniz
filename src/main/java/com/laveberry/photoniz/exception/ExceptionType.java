package com.laveberry.photoniz.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
public enum ExceptionType {

    PASSWORD_FAIL(HttpStatus.BAD_REQUEST,"A1000", "패스워드 생성에 실패하였습니다."),
    NOT_AUTHORIZED_TOKEN(HttpStatus.BAD_REQUEST,"A1001", "권한 정보가 없는 토큰 입니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U1000", "유저가 존재하지 않습니다."),
    SIGN_IN_FAILED(HttpStatus.BAD_REQUEST, "U1001", "로그인 정보가 잘못되었습니다."),
    USER_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "U1002", "이미 존재하는 사용자 입니다."),
    USER_DELETE_FAIL(HttpStatus.BAD_REQUEST, "U1003", "사용자 삭제에 실패하였습니다."),
    ADMIN_DO_NOT_DELETE(HttpStatus.BAD_REQUEST, "U1004", "관리자는 삭제할 수 없습니다.");

    private final HttpStatus status;
    private final String errorCode;
    private final String message;
}
