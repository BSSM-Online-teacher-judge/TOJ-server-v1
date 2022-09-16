package com.toj.teacheronlinejudge.domain.user.service;

import com.toj.teacheronlinejudge.domain.user.domain.repository.UserRepository;
import com.toj.teacheronlinejudge.domain.user.facade.UserFacade;
import com.toj.teacheronlinejudge.domain.user.presentation.dto.request.CheckCodeRequestDto;
import com.toj.teacheronlinejudge.domain.user.presentation.dto.request.CreateUserRequest;
import com.toj.teacheronlinejudge.global.redis.RedisService;
import com.toj.teacheronlinejudge.global.utils.RandomCodeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RedisService redisService;
    private final MailService mailService;

    private static final int CODE_LENGTH = 6;

    @Transactional
    public void signUp(CreateUserRequest dto) {
        userFacade.validateSignUp(dto.getEmail(), dto.getNickName());
        userFacade.validateEmail(dto.getEmail());

        userRepository.save(dto.toEntity(passwordEncoder));
    }

    @Transactional
    public void sendMail(String email) {
        String code = RandomCodeUtil.generateCode(CODE_LENGTH);

        redisService.setDataExpire(email, code, Duration.ofMinutes(3));

        mailService.sendMail(
                email,
                "[TOJ] Issue Code",
                mailService.genTemplateEngine("issue-code", Map.of("code", code)),
                true
        );
    }

    @Transactional
    public boolean checkCode(CheckCodeRequestDto dto) {
        if (redisService.getData(dto.getEmail()).equals(dto.getCode())) {
            redisService.deleteData(dto.getEmail());
            return true;
        }
        else {
            return false;
        }
    }
}
