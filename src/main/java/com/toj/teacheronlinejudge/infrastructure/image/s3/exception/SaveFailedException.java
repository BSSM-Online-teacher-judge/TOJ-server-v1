package com.toj.teacheronlinejudge.infrastructure.image.s3.exception;

import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import com.toj.teacheronlinejudge.global.error.exception.ErrorCode;

public class SaveFailedException extends BusinessException {

    public final static SaveFailedException EXCEPTION = new SaveFailedException();

    private SaveFailedException() {
        super(ErrorCode.FAILED_SAVE_FILE);
    }
}
