package com.toj.teacheronlinejudge.global.image.exception;

import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import com.toj.teacheronlinejudge.global.error.exception.ErrorCode;

public class TooLongTitleException extends BusinessException {

    public static final TooLongTitleException EXCEPTION = new TooLongTitleException();

    private TooLongTitleException() {
        super(ErrorCode.TOO_LONG_TITLE);
    }
}
