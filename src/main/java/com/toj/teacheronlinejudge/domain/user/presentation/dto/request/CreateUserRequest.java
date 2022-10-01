package com.toj.teacheronlinejudge.domain.user.presentation.dto.request;

import com.toj.teacheronlinejudge.domain.user.domain.User;
import com.toj.teacheronlinejudge.domain.user.domain.type.Authority;
import com.toj.teacheronlinejudge.global.image.DefaultProfileImg;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class CreateUserRequest {

    @NotBlank(message = "이메일이 비어있습니다!")
    @Email(message = "이메일을 포맷에 맞게 다시 입력해주세요!")
    private String email;

    @NotBlank(message = "비밀번호가 비어있습니다!")
    private String password;

    @NotBlank(message = "이름이 비어있습니다!")
    private String name;

    @NotBlank(message = "닉네임이 비어있습니다!")
    private String nickName;

    @NotNull(message = "학년을 입력해주세요!")
    private int grade;

    @NotNull(message = "반을 입력해주세요!")
    private int classRoom;

    public User toEntity(PasswordEncoder passwordEncoder) {
        return User.builder()
                .profileImg(DefaultProfileImg.DEFAULT_PROFILE_IMG)
                .email(email)
                .password(passwordEncoder.encode(password))
                .nickName(nickName)
                .name(name)
                .grade(grade)
                .classRoom(classRoom)
                .authority(Authority.USER)
                .build();
    }
}