package com.toj.teacheronlinejudge.domain.teacher.facade;

import com.toj.teacheronlinejudge.domain.teacher.domain.Comment;
import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.teacher.domain.repository.CommentRepository;
import com.toj.teacheronlinejudge.domain.teacher.exception.CommentNotFoundException;
import com.toj.teacheronlinejudge.domain.teacher.exception.UserForbiddenException;
import com.toj.teacheronlinejudge.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentFacade {

    private final CommentRepository commentRepository;

    public Comment findCommentById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }

    public void validateDeleteComment(User user, Comment comment) {
        if (!user.getEmail().equals(comment.getUser().getEmail())) {
            throw UserForbiddenException.EXCEPTION;
        }
    }

    public List<Comment> findAllCommentByTeacher(Teacher teacher) {
        return commentRepository.findByTeacher(teacher, Sort.by(Sort.Direction.DESC, "createdAt"));
    }
}
