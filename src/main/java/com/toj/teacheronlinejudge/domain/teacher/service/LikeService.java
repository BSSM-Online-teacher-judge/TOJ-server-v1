package com.toj.teacheronlinejudge.domain.teacher.service;

import com.toj.teacheronlinejudge.domain.teacher.domain.Like;
import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.teacher.domain.repository.LikeRepository;
import com.toj.teacheronlinejudge.domain.teacher.facade.LikeFacade;
import com.toj.teacheronlinejudge.domain.teacher.facade.TeacherFacade;
import com.toj.teacheronlinejudge.domain.user.domain.User;
import com.toj.teacheronlinejudge.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final TeacherFacade teacherFacade;
    private final UserFacade userFacade;
    private final LikeFacade likeFacade;

    @Transactional
    public void createLike(Long teacherId) {
        Teacher teacher = teacherFacade.findTeacherById(teacherId);
        User user = userFacade.findUserByEmail(userFacade.getCurrentUser().getEmail());

        likeFacade.validateCreateLike(teacher, user);

        likeRepository.save(Like.createLike(teacher, user));
    }

    @Transactional
    public void removeLike(Long teacherId) {
        Teacher teacher = teacherFacade.findTeacherById(teacherId);
        User user = userFacade.findUserByEmail(userFacade.getCurrentUser().getEmail());

        likeFacade.validateRemoveLike(teacher, user);

        likeRepository.deleteByTeacherAndUser(teacher, user);
    }
}
