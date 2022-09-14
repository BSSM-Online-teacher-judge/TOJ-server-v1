package com.toj.teacheronlinejudge.global.security.jwt.exception;

import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import com.toj.teacheronlinejudge.global.error.exception.ErrorCode;

public class AlreadyLogoutException extends BusinessException {

    public final static AlreadyLogoutException EXCEPTION = new AlreadyLogoutException();

    private AlreadyLogoutException() {
        super(ErrorCode.ALREADY_LOGOUT);
    }
}
