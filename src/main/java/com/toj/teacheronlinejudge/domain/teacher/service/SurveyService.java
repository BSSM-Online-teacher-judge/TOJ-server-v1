package com.toj.teacheronlinejudge.domain.teacher.service;

import com.toj.teacheronlinejudge.domain.teacher.domain.Survey;
import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.teacher.domain.repository.SurveyRepository;
import com.toj.teacheronlinejudge.domain.teacher.facade.SurveyFacade;
import com.toj.teacheronlinejudge.domain.teacher.facade.TeacherFacade;
import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.request.CreateSurveyRequestDto;
import com.toj.teacheronlinejudge.domain.user.domain.User;
import com.toj.teacheronlinejudge.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SurveyService {

    private final SurveyRepository surveyRepository;
    private final UserFacade userFacade;
    private final TeacherFacade teacherFacade;
    private final SurveyFacade surveyFacade;

    @Transactional
    public void createSurvey(Long id, CreateSurveyRequestDto dto) {
        User user = userFacade.getUserWithSurvey(userFacade.getCurrentUser().getId());

        surveyFacade.validateCreateSurvey(user);

        Teacher teacher = teacherFacade.findTeacherById(id);


        Survey survey = dto.toEntity();
        survey.setRelation(teacher, user);

        surveyRepository.save(survey);
    }
}
