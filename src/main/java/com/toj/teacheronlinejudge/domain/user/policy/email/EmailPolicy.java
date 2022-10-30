package com.toj.teacheronlinejudge.domain.user.policy.email;

public interface EmailPolicy {

    boolean isSchoolEmail(String email);

    boolean isTeacherEmail(String email);
}
