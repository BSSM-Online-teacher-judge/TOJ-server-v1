package com.toj.teacheronlinejudge.domain.user.facade;

import com.toj.teacheronlinejudge.domain.user.domain.repository.UserRepository;
import com.toj.teacheronlinejudge.domain.user.exception.NotBssmStudentException;
import com.toj.teacheronlinejudge.domain.user.exception.NotStudentException;
import com.toj.teacheronlinejudge.domain.user.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public void validateSignUp(String email, String nickName) {
        if (userRepository.existsByEmailAndNickName(email, nickName)) {
            throw UserAlreadyExistsException.EXCEPTION;
        }
    }

    public void validateEmail(String email) {
        if (!email.endsWith("@bssm.hs.kr") && email.length() != 9) {
            throw NotBssmStudentException.EXCEPTION;
        }

        if (email.startsWith("teacher")) {
            throw NotStudentException.EXCEPTION;
        }
    }
}
