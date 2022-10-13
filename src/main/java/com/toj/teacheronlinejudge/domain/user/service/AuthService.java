package com.toj.teacheronlinejudge.domain.user.service;

import com.toj.teacheronlinejudge.domain.user.domain.User;
import com.toj.teacheronlinejudge.domain.user.facade.UserFacade;
import com.toj.teacheronlinejudge.domain.user.presentation.dto.request.LoginRequestDto;
import com.toj.teacheronlinejudge.domain.user.presentation.dto.response.TokenResponseDto;
import com.toj.teacheronlinejudge.global.redis.RedisService;
import com.toj.teacheronlinejudge.global.security.jwt.JwtTokenProvider;
import com.toj.teacheronlinejudge.global.security.jwt.JwtValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.Date;

import static com.toj.teacheronlinejudge.global.security.jwt.JwtProperties.ACCESS_TOKEN_VALID_TIME;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserFacade userFacade;
    private final JwtTokenProvider jwtTokenProvider;
    private final RedisService redisService;
    private final JwtValidateService jwtValidateService;

    @Transactional
    public TokenResponseDto login(LoginRequestDto dto) {
        User user =  userFacade.findUserByEmail(dto.getEmail());
        userFacade.checkLoginUser(user, dto.getPassword());

        final String accessToken = jwtTokenProvider.createAccessToken(dto.getEmail());
        final String refreshToken = jwtTokenProvider.createRefreshToken(dto.getEmail());
        redisService.setDataExpire(dto.getEmail(), refreshToken, Duration.ofMillis(ACCESS_TOKEN_VALID_TIME));

        return TokenResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .authority(user.getAuthority())
                .build();
    }

    @Transactional
    public void logout(String accessToken) {
        User user = userFacade.getCurrentUser();

        String parsedAccessToken = jwtTokenProvider.parseToken(accessToken);
        long remainTime = jwtTokenProvider.getExpiredTime(parsedAccessToken).getTime() - new Date().getTime();
        redisService.setBlackList(parsedAccessToken, Duration.ofMillis(remainTime));

        redisService.deleteData(user.getEmail());
    }

    @Transactional
    public TokenResponseDto getNewAccessToken(String refreshToken) {
        jwtValidateService.validateRefreshToken(refreshToken);

        return TokenResponseDto.builder()
                .accessToken(
                        jwtTokenProvider.createAccessToken(
                                jwtValidateService.getEmail(refreshToken)
                        )
                )
                .build();
    }
}
