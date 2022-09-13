package com.toj.teacheronlinejudge.domain.teacher.service;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.teacher.domain.repository.TeacherRepository;
import com.toj.teacheronlinejudge.domain.teacher.facade.TeacherFacade;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.request.TeacherRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherFacade teacherFacade;

    @Transactional
    public void createTeacher(TeacherRequestDto dto) {
        teacherRepository.save(dto.toEntity());
    }

    @Transactional
    public void deleteTeacher(Long id) {
        teacherRepository.delete(teacherFacade.findTeacherById(id));
    }

    @Transactional
    public void updateTeacher(Long id, TeacherRequestDto dto) {
        Teacher teacher = teacherFacade.findTeacherById(id);
        teacher.updateTeacher(dto.getProfileImg(), dto.getName(), dto.getDescription());
    }
}
