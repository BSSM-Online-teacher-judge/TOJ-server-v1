package com.toj.teacheronlinejudge.domain.ad.exception;

import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import com.toj.teacheronlinejudge.global.error.exception.ErrorCode;

public class AlreadyCloseAdException extends BusinessException {

    public final static AlreadyCloseAdException EXCEPTION = new AlreadyCloseAdException();

    private AlreadyCloseAdException() {
        super(ErrorCode.ALREADY_CLOSE_AD);
    }
}
