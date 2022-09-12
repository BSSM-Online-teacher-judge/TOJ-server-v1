package com.toj.teacheronlinejudge.domain.user.presentation;

import com.toj.teacheronlinejudge.domain.user.presentation.dto.request.CreateUserRequest;
import com.toj.teacheronlinejudge.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
