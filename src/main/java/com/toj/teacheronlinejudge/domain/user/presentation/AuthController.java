package com.toj.teacheronlinejudge.domain.user.presentation;

import com.toj.teacheronlinejudge.domain.user.presentation.dto.request.LoginRequestDto;
import com.toj.teacheronlinejudge.domain.user.presentation.dto.response.TokenResponseDto;
import com.toj.teacheronlinejudge.domain.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public TokenResponseDto login(@RequestBody @Valid LoginRequestDto dto) {
        return authService.login(dto);
    }
}
