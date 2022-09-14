package com.toj.teacheronlinejudge.domain.teacher.service;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.teacher.domain.repository.TeacherRepository;
import com.toj.teacheronlinejudge.domain.teacher.facade.TeacherFacade;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.request.TeacherRequestDto;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.response.TeacherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public Set<TeacherResponseDto> findTeacherList() {
        return teacherRepository.findAll().stream()
                .map(TeacherResponseDto::of)
                .collect(Collectors.toSet());
    }
}
