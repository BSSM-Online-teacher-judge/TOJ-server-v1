package com.toj.teacheronlinejudge.domain.teacher.facade;

import com.toj.teacheronlinejudge.domain.teacher.domain.repository.SurveyRepository;
import com.toj.teacheronlinejudge.domain.teacher.exception.NotTodayException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SurveyFacade {

    private final SurveyRepository surveyRepository;

    public void validateCreateSurvey() {
        List<Integer> dates = List.of(24, 25, 26, 27, 28, 29, 30, 31);
        int dayOfNow = LocalDateTime.now().getDayOfMonth();

        if (!dates.contains(dayOfNow)) {
            throw NotTodayException.EXCEPTION;
        }
    }
}
