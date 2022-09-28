package com.toj.teacheronlinejudge.domain.teacher.facade;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.teacher.domain.repository.LikeRepository;
import com.toj.teacheronlinejudge.domain.teacher.exception.AlreadyLikeException;
import com.toj.teacheronlinejudge.domain.teacher.exception.LikeNotFoundException;
import com.toj.teacheronlinejudge.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LikeFacade {

    private final LikeRepository likeRepository;

    public void validateCreateLike(Teacher teacher, User user) {
        if (likeRepository.existsByTeacherAndUser(teacher, user)) {
            throw AlreadyLikeException.EXCEPTION;
        }
    }

    public void validateRemoveLike(Teacher teacher, User user) {
        if (!likeRepository.existsByTeacherAndUser(teacher, user)) {
            throw LikeNotFoundException.EXCEPTION;
        }
    }
}
