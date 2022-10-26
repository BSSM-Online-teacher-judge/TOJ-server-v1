package com.toj.teacheronlinejudge.domain.teacher.presentation.dto.response;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeacherOfTheMonthResponseDto {

    private String profileImg;

    private String name;

    private String description;

    private int tier;


    public static TeacherOfTheMonthResponseDto of(Teacher teacher) {
        return TeacherOfTheMonthResponseDto.builder()
            .profileImg(teacher.getProfileImg())
            .name(teacher.getName())
            .description(teacher.getDescription())
            .tier(teacher.getTier())
            .build();
    }
}
