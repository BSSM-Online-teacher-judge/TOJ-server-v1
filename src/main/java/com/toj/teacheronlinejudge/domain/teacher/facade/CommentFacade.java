package com.toj.teacheronlinejudge.domain.teacher.facade;

import com.toj.teacheronlinejudge.domain.teacher.domain.Comment;
import com.toj.teacheronlinejudge.domain.teacher.domain.repository.CommentRepository;
import com.toj.teacheronlinejudge.domain.teacher.exception.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentFacade {

    private final CommentRepository commentRepository;

    public Comment findCommentById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }
}
