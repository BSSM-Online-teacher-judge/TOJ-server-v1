package com.toj.teacheronlinejudge.domain.teacher.presentation.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class ChildCommentRequestDto {

    @NotNull
    private Long teacherId;

    @NotNull
    private Long commentId;

    @NotEmpty(message = "내용이 비었습니다!")
    @Size(min = 1, max = 500)
    private String content;
}
