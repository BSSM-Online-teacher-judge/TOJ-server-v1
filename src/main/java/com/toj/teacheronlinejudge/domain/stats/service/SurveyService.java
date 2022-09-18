package com.toj.teacheronlinejudge.domain.stats.service;

import com.toj.teacheronlinejudge.domain.stats.domain.Survey;
import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.stats.domain.repository.SurveyRepository;
import com.toj.teacheronlinejudge.domain.stats.facade.SurveyFacade;
import com.toj.teacheronlinejudge.domain.teacher.facade.TeacherFacade;
import com.toj.teacheronlinejudge.domain.stats.presentation.dto.request.CreateSurveyRequestDto;
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
    private final StatsService statsService;

    @Transactional
    public void createSurvey(Long id, CreateSurveyRequestDto dto) {
        User user = userFacade.getUserWithSurvey(userFacade.getCurrentUser().getId());

        surveyFacade.validateCreateSurvey(user);

        Teacher teacher = teacherFacade.findTeacherById(id);


        Survey survey = dto.toEntity();
        survey.setRelation(teacher, user);

        statsService.updateStats(survey);

        surveyRepository.save(survey);
    }
}
