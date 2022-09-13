package com.toj.teacheronlinejudge.domain.teacher.presentation.dto.response;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeacherResponseDto {
    private Long id;
    private String name;
    private String description;
    private String profileImg;

    public static TeacherResponseDto of(Teacher teacher) {
        return TeacherResponseDto.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .description(teacher.getDescription())
                .profileImg(teacher.getProfileImg())
                .build();
    }
}
