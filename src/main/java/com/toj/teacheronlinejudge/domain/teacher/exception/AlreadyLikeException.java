package com.toj.teacheronlinejudge.domain.teacher.exception;

import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import com.toj.teacheronlinejudge.global.error.exception.ErrorCode;

public class AlreadyLikeException extends BusinessException {

    public static final AlreadyLikeException EXCEPTION = new AlreadyLikeException();

    private AlreadyLikeException() {
        super(ErrorCode.ALREADY_LIKE);
    }
}
