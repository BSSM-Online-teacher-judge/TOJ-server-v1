package com.toj.teacheronlinejudge.domain.user.exception;

import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import com.toj.teacheronlinejudge.global.error.exception.ErrorCode;

public class NotStudentException extends BusinessException {

    public final static NotStudentException EXCEPTION = new NotStudentException();

    private NotStudentException() {
        super(ErrorCode.NOT_STUDENT);
    }
}
