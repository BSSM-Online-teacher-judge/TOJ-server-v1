package com.toj.teacheronlinejudge.domain.teacher.exception;

import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import com.toj.teacheronlinejudge.global.error.exception.ErrorCode;

public class UserForbiddenException extends BusinessException {

    public static final UserForbiddenException EXCEPTION = new UserForbiddenException();

    private UserForbiddenException() {
        super(ErrorCode.USER_FORBIDDEN);
    }
}
