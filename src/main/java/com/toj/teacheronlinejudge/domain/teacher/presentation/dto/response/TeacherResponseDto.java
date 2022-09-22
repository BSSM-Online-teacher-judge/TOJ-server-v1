package com.toj.teacheronlinejudge.domain.teacher.presentation.dto.response;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeacherResponseDto {
    private Long id;
    private String name;
    private String description;
    private String profileImg;
    private boolean isCompleted;
    private int numberOfSubmit;

    public static TeacherResponseDto of(Teacher teacher, User user) {
        boolean isCompleted = teacher.getSurveyList().stream()
                .anyMatch(survey -> survey.getUser().getEmail().equals(user.getEmail()));

        return TeacherResponseDto.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .description(teacher.getDescription())
                .profileImg(teacher.getProfileImg())
                .isCompleted(isCompleted)
                .numberOfSubmit(teacher.getSurveyList().size())
                .build();
    }
}
