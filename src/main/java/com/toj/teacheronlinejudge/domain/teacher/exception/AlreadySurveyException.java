package com.toj.teacheronlinejudge.domain.teacher.exception;

import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import com.toj.teacheronlinejudge.global.error.exception.ErrorCode;

public class AlreadySurveyException extends BusinessException {

    public static final AlreadySurveyException EXCEPTION = new AlreadySurveyException();

    private AlreadySurveyException() {
        super(ErrorCode.ALREADY_SURVEY);
    }
}
