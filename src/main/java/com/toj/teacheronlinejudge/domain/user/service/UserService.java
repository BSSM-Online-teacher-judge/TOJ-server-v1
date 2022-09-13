package com.toj.teacheronlinejudge.domain.user.service;

import com.toj.teacheronlinejudge.domain.user.domain.repository.UserRepository;
import com.toj.teacheronlinejudge.domain.user.facade.UserFacade;
import com.toj.teacheronlinejudge.domain.user.presentation.dto.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(CreateUserRequest dto) {
        userFacade.validateSignUp(dto.getEmail(), dto.getNickName());
        userFacade.validateEmail(dto.getEmail());

        userRepository.save(dto.toEntity(passwordEncoder));
    }
}
