package com.toj.teacheronlinejudge.domain.user.policy.email;

import org.springframework.stereotype.Component;

@Component
public class EmailPolicyImpl implements EmailPolicy {

    @Override
    public boolean isSchoolEmail(String email) {

        boolean isCorrectForm = email.endsWith("@bssm.hs.kr");
        boolean isCorrectSize = email.length() != 9;

        return isCorrectForm && isCorrectSize;
    }

    @Override
    public boolean isTeacherEmail(String email) {
        return email.contains("teacher");
    }
}
