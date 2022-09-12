package com.toj.teacheronlinejudge.domain.user.exception;

import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import com.toj.teacheronlinejudge.global.error.exception.ErrorCode;

public class NotBssmStudentException extends BusinessException {

    public final static NotBssmStudentException EXCEPTION = new NotBssmStudentException();

    private NotBssmStudentException() {
        super(ErrorCode.NOT_BSSM_STUDENT);
    }
}
