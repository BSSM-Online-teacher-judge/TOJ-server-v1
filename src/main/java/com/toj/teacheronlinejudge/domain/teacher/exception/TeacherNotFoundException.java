package com.toj.teacheronlinejudge.domain.teacher.exception;

import com.toj.teacheronlinejudge.global.error.exception.BusinessException;
import com.toj.teacheronlinejudge.global.error.exception.ErrorCode;

public class TeacherNotFoundException extends BusinessException {

    public static final TeacherNotFoundException EXCEPTION = new TeacherNotFoundException();

    private TeacherNotFoundException() {
        super(ErrorCode.TEACHER_NOT_FOUND);
    }
}
