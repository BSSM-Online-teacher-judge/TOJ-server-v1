package com.toj.teacheronlinejudge.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponseDto {

    private String accessToken;

    private String refreshToken;
}
