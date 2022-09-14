package com.toj.teacheronlinejudge.domain.teacher.facade;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.teacher.domain.repository.TeacherRepository;
import com.toj.teacheronlinejudge.domain.teacher.exception.TeacherNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherFacade {

    private final TeacherRepository teacherRepository;

    public Teacher findTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> TeacherNotFoundException.EXCEPTION);
    }
}
