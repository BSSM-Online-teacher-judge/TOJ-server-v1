package com.toj.teacheronlinejudge.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "서버에 오류가 발생했습니다."),
    BAD_REQUEST(400, "잘못된 요청입니다."),

    USER_ALREADY_EXISTS(422, "이미 존재하는 유저입니다."),
    NOT_STUDENT(422, "학생이 아닙니다!"),
    NOT_BSSM_STUDENT( 422, "부산소마고 학생이 아닙니다!"),
    ;

    private final int status;
    private final String message;
}
