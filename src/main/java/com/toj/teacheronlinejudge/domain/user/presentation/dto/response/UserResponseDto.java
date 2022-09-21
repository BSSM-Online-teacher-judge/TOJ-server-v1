package com.toj.teacheronlinejudge.domain.user.presentation.dto.response;

import com.toj.teacheronlinejudge.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDto {

    private Long id;
    private String email;
    private String name;
    private String nickName;
    private int grade;
    private int classRoom;

    public static UserResponseDto of(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .nickName(user.getNickName())
                .grade(user.getGrade())
                .classRoom(user.getClassRoom())
                .build();
    }
}
