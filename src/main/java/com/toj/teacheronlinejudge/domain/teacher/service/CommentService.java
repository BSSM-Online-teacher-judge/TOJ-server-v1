package com.toj.teacheronlinejudge.domain.teacher.service;

import com.toj.teacheronlinejudge.domain.teacher.domain.Comment;
import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.teacher.domain.repository.CommentRepository;
import com.toj.teacheronlinejudge.domain.teacher.facade.CommentFacade;
import com.toj.teacheronlinejudge.domain.teacher.facade.TeacherFacade;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.request.ChildCommentRequestDto;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.request.CommentRequestDto;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.response.CommentResponseDto;
import com.toj.teacheronlinejudge.domain.user.domain.User;
import com.toj.teacheronlinejudge.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentFacade commentFacade;
    private final TeacherFacade teacherFacade;
    private final UserFacade userFacade;

    @Transactional
    public void createComment(CommentRequestDto dto) {
        Teacher teacher = teacherFacade.findTeacherById(dto.getTeacherId());
        User user = userFacade.getUserWithComment(userFacade.getCurrentUser().getId());

        commentRepository.save(
                Comment.createComment(dto.getContent(), teacher, user)
        );
    }

    @Transactional
    public void createChildComment(ChildCommentRequestDto dto) {
        Teacher teacher = teacherFacade.findTeacherById(dto.getTeacherId());
        User user = userFacade.getUserWithComment(userFacade.getCurrentUser().getId());

        Comment parent = commentFacade.findCommentById(dto.getCommentId());

        commentRepository.save(
                Comment.createComment(dto.getContent(), teacher, user)
                        .setParent(parent)
        );
    }

    @Transactional
    public void deleteComment(Long id) {
        User user = userFacade.getCurrentUser();
        Comment comment = commentFacade.findCommentById(id);

        commentFacade.validateDeleteComment(user, comment);
        commentRepository.delete(comment);
    }

    @Transactional(readOnly = true)
    public List<CommentResponseDto> findComments(Long teacherId) {
        Teacher teacher = teacherFacade.findTeacherById(teacherId);
        return commentFacade.findAllCommentByTeacher(teacher).stream()
                .filter(comment -> comment.getParent() == null)
                .map(CommentResponseDto::of)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<CommentResponseDto> findChildComments(Long id) {
        Comment comment = commentFacade.findCommentById(id);

        return comment.getChildren().stream()
                .sorted(Comparator.comparing(Comment::getCreatedAt, Comparator.reverseOrder()))
                .map(CommentResponseDto::of)
                .collect(Collectors.toList());
    }
}
