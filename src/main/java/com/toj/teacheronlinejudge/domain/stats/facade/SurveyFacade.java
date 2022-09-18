package com.toj.teacheronlinejudge.domain.stats.facade;

import com.toj.teacheronlinejudge.domain.stats.domain.repository.SurveyRepository;
import com.toj.teacheronlinejudge.domain.stats.exception.AlreadySurveyException;
import com.toj.teacheronlinejudge.domain.user.domain.User;
import com.toj.teacheronlinejudge.global.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SurveyFacade {

    private final SurveyRepository surveyRepository;

    public void validateCreateSurvey(User user) {
        if (surveyRepository.existsByUserAndCreatedAtAfter(user, DateUtil.monthOfStart())) {
            throw AlreadySurveyException.EXCEPTION;
        }
    }
}
