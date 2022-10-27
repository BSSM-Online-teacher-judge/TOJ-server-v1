package com.toj.teacheronlinejudge.domain.teacher.presentation.dto.request;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.infrastructure.image.s3.DefaultProfileImg;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
public class TeacherRequestDto {

    @NotEmpty(message = "이름을 입력해주세요")
    @Size(min = 2, max = 6)
    private String name;

    @NotEmpty(message = "설명란이 비었습니다")
    @Size(min = 5, max = 500)
    private String description;

    public Teacher toEntity() {
        return Teacher.builder()
                .profileImg(DefaultProfileImg.DEFAULT_PROFILE_IMG)
                .name(name)
                .description(description)
                .build();
    }
}
