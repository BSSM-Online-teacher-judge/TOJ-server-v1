package com.toj.teacheronlinejudge.domain.teacher.service;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.teacher.domain.repository.TeacherRepository;
import com.toj.teacheronlinejudge.domain.teacher.facade.TeacherFacade;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.request.TeacherRequestDto;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.response.TeacherOfTheMonthResponseDto;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.response.TeacherRankingResponseDto;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.response.TeacherResponseDto;
import com.toj.teacheronlinejudge.domain.user.domain.User;
import com.toj.teacheronlinejudge.domain.user.facade.UserFacade;
import com.toj.teacheronlinejudge.infrastructure.image.s3.S3Properties;
import com.toj.teacheronlinejudge.infrastructure.image.s3.facade.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final S3Properties s3Properties;
    private final TeacherRepository teacherRepository;
    private final TeacherFacade teacherFacade;
    private final UserFacade userFacade;
    private final S3Facade s3Facade;

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
        return teacherRepository.findAllByOrderByTierDesc().stream()
                .map(TeacherRankingResponseDto::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateTeacherProfile(Long id, MultipartFile multipartFile) {
        Teacher teacher = teacherFacade.findTeacherById(id);
        teacher.updateProfileImg(s3Facade.uploadImage(multipartFile, s3Properties.getTeacher()));
    }

    @Transactional(readOnly = true)
    public List<TeacherOfTheMonthResponseDto> findTeacherOfTheMonth() {
        return teacherRepository.findTop3ByOrderByTierDesc().stream()
            .map(TeacherOfTheMonthResponseDto::of)
            .collect(Collectors.toList());
    }
}
