package com.toj.teacheronlinejudge.domain.teacher.exception;

import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import com.toj.teacheronlinejudge.global.error.exception.ErrorCode;

public class LikeNotFoundException extends BusinessException {

    public static final LikeNotFoundException EXCEPTION = new LikeNotFoundException();

    private LikeNotFoundException () {
        super(ErrorCode.LIKE_NOT_FOUND);
    }
}
