package com.laveberry.photoniz.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
public enum ExceptionType {

    PASSWORD_FAIL(HttpStatus.BAD_REQUEST,"A1000", "패스워드 생성에 실패하였습니다."),
    NOT_AUTHORIZED_TOKEN(HttpStatus.UNAUTHORIZED,"A1001", "유효하지 않은 토큰 입니다."),
    EXPIRE_TOKEN(HttpStatus.UNAUTHORIZED,"A1002", "토큰이 만료되었습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U1000", "유저가 존재하지 않습니다."),
    SIGN_IN_FAILED(HttpStatus.BAD_REQUEST, "U1001", "로그인 정보가 잘못되었습니다."),
    USER_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "U1002", "이미 존재하는 사용자 입니다."),
    USER_DELETE_FAIL(HttpStatus.BAD_REQUEST, "U1003", "사용자 삭제에 실패하였습니다."),
    ADMIN_DO_NOT_DELETE(HttpStatus.BAD_REQUEST, "U1004", "관리자는 삭제할 수 없습니다."),
    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "B1000", "게시물이 존재하지 않습니다."),
    INCORRECT_BOARD_TYPE(HttpStatus.BAD_REQUEST, "B1001", "게시판 타입이 적절하지 않습니다."),
    NOT_BOARD_USER(HttpStatus.BAD_REQUEST, "B1002", "게시물 수정/삭제 권한이 없습니다."),
    FILE_UPLOAD_FAIL(HttpStatus.BAD_REQUEST, "F1000", "파일 업로드에 실패했습니다.");

    private final HttpStatus status;
    private final String errorCode;
    private final String message;
}
