package com.toj.teacheronlinejudge.domain.teacher.presentation.dto.response;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeacherDetailResponseDto {
    private Long id;
    private String profileImg;
    private String name;
    private String description;

    public static TeacherDetailResponseDto of(Teacher teacher) {
        return TeacherDetailResponseDto.builder()
                .id(teacher.getId())
                .profileImg(teacher.getProfileImg())
                .name(teacher.getName())
                .description(teacher.getDescription())
                .build();
    }
}
