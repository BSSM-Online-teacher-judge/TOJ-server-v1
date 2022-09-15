package com.toj.teacheronlinejudge.domain.teacher.presentation.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class CommentRequestDto {

    private Long teacherId;

    @NotEmpty(message = "내용이 비었습니다!")
    @Size(min = 1, max = 500)
    private String content;
}
