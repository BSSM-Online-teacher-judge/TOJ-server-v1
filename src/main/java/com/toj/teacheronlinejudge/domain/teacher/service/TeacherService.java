package com.toj.teacheronlinejudge.domain.teacher.service;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.teacher.domain.repository.TeacherRepository;
import com.toj.teacheronlinejudge.domain.teacher.facade.TeacherFacade;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.request.TeacherRequestDto;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.response.TeacherRankingResponseDto;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.response.TeacherResponseDto;
import com.toj.teacheronlinejudge.domain.user.domain.User;
import com.toj.teacheronlinejudge.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherFacade teacherFacade;
    private final UserFacade userFacade;

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
        teacher.updateTeacher(dto.getName(), dto.getDescription());
    }

    @Transactional(readOnly = true)
    public List<TeacherResponseDto> findTeacherList() {
        User user = userFacade.getCurrentUser();

        return teacherRepository.findAllByOrderByLikesDesc().stream()
                .map(teacher -> TeacherResponseDto.of(teacher, user))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TeacherResponseDto findTeacherDetail(Long id) {
        User user = userFacade.getCurrentUser();
        return TeacherResponseDto.of(teacherFacade.findTeacherById(id), user);
    }

    @Transactional(readOnly = true)
    public List<TeacherRankingResponseDto> findTeacherRanking() {
        User user = userFacade.getCurrentUser();

        return teacherRepository.findAllByOrderByTierDesc().stream()
                .map(TeacherRankingResponseDto::of)
                .collect(Collectors.toList());
    }
}
