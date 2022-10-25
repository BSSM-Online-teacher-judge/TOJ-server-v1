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
    private int numberOfSubmit;
    private int numberOfLikes;
    private boolean isCompleted;
    private boolean isLiked;

    public static TeacherResponseDto of(Teacher teacher, User user) {

        boolean isCompleted = teacher.getSurveyList().stream()
            .anyMatch(survey -> survey.getUser().getEmail().equals(user.getEmail()));

        boolean isLiked = teacher.getLikes().stream()
            .anyMatch(like -> like.getUser().getEmail().equals(user.getEmail()));

        return TeacherResponseDto.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .description(teacher.getDescription())
                .profileImg(teacher.getProfileImg())
                .numberOfSubmit(teacher.getSurveyList().size())
                .numberOfLikes(teacher.getLikes().size())
                .isCompleted(isCompleted)
                .isLiked(isLiked)
                .build();
    }
}
