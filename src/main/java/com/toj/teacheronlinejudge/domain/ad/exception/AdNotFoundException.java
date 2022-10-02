package com.toj.teacheronlinejudge.domain.ad.exception;

import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import com.toj.teacheronlinejudge.global.error.exception.ErrorCode;

public class AdNotFoundException extends BusinessException {

    public static final AdNotFoundException EXCEPTION = new AdNotFoundException();

    private AdNotFoundException() {
        super(ErrorCode.AD_NOT_FOUND);
    }
}
