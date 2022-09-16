package com.toj.teacheronlinejudge.domain.user.presentation.dto.request;

import lombok.Getter;

@Getter
public class CheckCodeRequestDto {
    private String email;
    private String code;
}
