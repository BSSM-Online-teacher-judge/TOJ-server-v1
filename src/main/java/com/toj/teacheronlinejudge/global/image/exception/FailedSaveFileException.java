package com.toj.teacheronlinejudge.global.image.exception;

import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import com.toj.teacheronlinejudge.global.error.exception.ErrorCode;

public class FailedSaveFileException extends BusinessException {

    public final static FailedSaveFileException EXCEPTION = new FailedSaveFileException();

    private FailedSaveFileException() {
        super(ErrorCode.FAILED_SAVE_FILE);
    }
}
