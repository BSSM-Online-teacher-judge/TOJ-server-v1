package com.toj.teacheronlinejudge.domain.teacher.presentation;

import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.request.ChildCommentRequestDto;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.request.CommentRequestDto;
import com.toj.teacheronlinejudge.domain.teacher.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public void createComment(@RequestBody CommentRequestDto dto) {
        commentService.createComment(dto);
    }

    @PostMapping("/child")
    public void createChildComment(@RequestBody ChildCommentRequestDto dto) {
        commentService.createChildComment(dto);
    }
}
