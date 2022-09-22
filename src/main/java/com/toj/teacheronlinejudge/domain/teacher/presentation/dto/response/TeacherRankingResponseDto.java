package com.toj.teacheronlinejudge.domain.teacher.presentation.dto.response;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeacherRankingResponseDto {
    private Long id;
    private String name;
    private String description;
    private String profileImg;

    public static TeacherRankingResponseDto of(Teacher teacher) {
        return TeacherRankingResponseDto.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .description(teacher.getDescription())
                .profileImg(teacher.getProfileImg())
                .build();
    }
}
