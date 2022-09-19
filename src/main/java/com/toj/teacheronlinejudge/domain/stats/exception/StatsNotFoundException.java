package com.toj.teacheronlinejudge.domain.stats.exception;

import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import com.toj.teacheronlinejudge.global.error.exception.ErrorCode;

public class StatsNotFoundException extends BusinessException {

    public static final StatsNotFoundException EXCEPTION = new StatsNotFoundException();

    private StatsNotFoundException() {
        super(ErrorCode.STATS_NOT_FOUND);
    }
}
