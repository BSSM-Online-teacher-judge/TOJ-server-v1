package com.toj.teacheronlinejudge.domain.user.facade;

import com.toj.teacheronlinejudge.domain.user.domain.User;
import com.toj.teacheronlinejudge.domain.user.domain.repository.UserRepository;
import com.toj.teacheronlinejudge.domain.user.exception.*;
import com.toj.teacheronlinejudge.domain.user.policy.email.EmailPolicy;
import com.toj.teacheronlinejudge.global.security.auth.AuthDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailPolicy emailPolicy;

    public void validateSignUp(String email, String nickName) {
        if (userRepository.existsByEmailAndNickName(email, nickName)) {
            throw UserAlreadyExistsException.EXCEPTION;
        }
    }

    public void validateEmail(String email) {

        if (!emailPolicy.isSchoolEmail(email)) {
            throw NotBssmStudentException.EXCEPTION;
        }

        if (emailPolicy.isTeacherEmail(email)) {
            throw NotStudentException.EXCEPTION;
        }
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void checkLoginUser(User user, String password) {
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }
    }

    public User getCurrentUser() {
        AuthDetails auth = (AuthDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return findUserByEmail(auth.getUsername());
    }

    public User getUserWithComment(Long id) {
        return userRepository.findUserWithComment(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User getUserWithSurvey(Long id) {
        return userRepository.findUserWithSurvey(id)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
