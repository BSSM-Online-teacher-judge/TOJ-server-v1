package com.toj.teacheronlinejudge.global.image.exception;

import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import com.toj.teacheronlinejudge.global.error.exception.ErrorCode;

public class EmptyFileException extends BusinessException {

    public static final EmptyFileException EXCEPTION = new EmptyFileException();

    private EmptyFileException() {
        super(ErrorCode.EMPTY_FILE);
    }
}
