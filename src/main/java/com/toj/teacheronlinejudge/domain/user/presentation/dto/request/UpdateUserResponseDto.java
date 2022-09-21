package com.toj.teacheronlinejudge.domain.user.presentation.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class UpdateUserResponseDto {

    @NotEmpty
    private String nickName;
}
