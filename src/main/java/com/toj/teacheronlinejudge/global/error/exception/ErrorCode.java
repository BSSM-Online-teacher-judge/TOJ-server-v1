package com.toj.teacheronlinejudge.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "서버에 오류가 발생했습니다."),
    BAD_REQUEST(400, "잘못된 요청입니다."),

    NOT_STUDENT(422, "학생이 아닙니다!"),
    NOT_BSSM_STUDENT( 422, "부산소마고 학생이 아닙니다!"),

    USER_ALREADY_EXISTS(422, "이미 존재하는 유저입니다."),
    USER_NOT_FOUND(404, "존재하지 않는 사용자입니다."),

    PASSWORD_MISMATCH( 401, "비밀번호가 틀렸습니다!"),

    EXPIRED_TOKEN(401, "토큰이 만료 되었습니다!"),
    INVALID_TOKEN(401, "유효하지 않은 토큰입니다!"),
    ALREADY_LOGOUT( 422, "이미 로그아웃한 유저입니다."),

    TEACHER_NOT_FOUND( 404, "존재하지 않는 선생님입니다!"),

    COMMENT_NOT_FOUND(404, "댓글을 찾을 수 없습니다."),
    USER_FORBIDDEN( 403, "유저에게 권한이 없습니다.");

    private final int status;
    private final String message;
}
