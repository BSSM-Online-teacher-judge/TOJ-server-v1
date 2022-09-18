package com.toj.teacheronlinejudge.domain.stats.exception;

import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import com.toj.teacheronlinejudge.global.error.exception.ErrorCode;

public class NotTodayException extends BusinessException {

    public static final NotTodayException EXCEPTION = new NotTodayException();

    private NotTodayException() {
        super(ErrorCode.NOT_TODAY);
    }
}
