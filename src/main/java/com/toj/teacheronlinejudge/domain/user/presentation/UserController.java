package com.toj.teacheronlinejudge.domain.user.presentation;

import com.toj.teacheronlinejudge.domain.user.presentation.dto.request.CheckCodeRequestDto;
import com.toj.teacheronlinejudge.domain.user.presentation.dto.request.CreateUserRequest;
import com.toj.teacheronlinejudge.domain.user.presentation.dto.request.UpdateUserResponseDto;
import com.toj.teacheronlinejudge.domain.user.presentation.dto.response.UserResponseDto;
import com.toj.teacheronlinejudge.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void signUp(
            @RequestBody @Valid CreateUserRequest dto
    ) {
        userService.signUp(dto);
    }

    @GetMapping
    public UserResponseDto findCurrentUser() {
        return userService.findCurrentUser();
    }

    @PutMapping
    public void updateUser(@RequestBody @Valid UpdateUserResponseDto dto) {
        userService.updateUser(dto);
    }

    @PostMapping("/send-mail")
    public void sendMail(@RequestParam String email) {
        userService.sendMail(email);
    }

    @DeleteMapping("/check-code")
    public boolean checkCode(@RequestBody CheckCodeRequestDto dto) {
        return userService.checkCode(dto);
    }
}