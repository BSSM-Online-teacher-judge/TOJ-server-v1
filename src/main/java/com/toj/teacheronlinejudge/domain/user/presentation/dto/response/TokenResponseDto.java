package com.toj.teacheronlinejudge.domain.user.presentation.dto.response;

import com.toj.teacheronlinejudge.domain.user.domain.type.Authority;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponseDto {

    private String accessToken;

    private String refreshToken;

    private Authority authority;
}
