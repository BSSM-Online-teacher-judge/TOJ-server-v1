package com.toj.teacheronlinejudge.domain.stats.facade;

import com.toj.teacheronlinejudge.domain.stats.domain.repository.SurveyRepository;
import com.toj.teacheronlinejudge.domain.stats.exception.AlreadySurveyException;
import com.toj.teacheronlinejudge.domain.stats.exception.NotTodayException;
import com.toj.teacheronlinejudge.domain.user.domain.User;
import com.toj.teacheronlinejudge.global.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SurveyFacade {

    private final SurveyRepository surveyRepository;

    public void validateCreateSurvey(User user) {
        List<Integer> dates = List.of(24, 25, 26, 27, 28, 29, 30, 31);
        int dayOfNow = LocalDateTime.now().getDayOfMonth();

        if (!dates.contains(dayOfNow)) {
            throw NotTodayException.EXCEPTION;
        }
        if (surveyRepository.existsByUserAndCreatedAtAfter(user, DateUtil.monthOfToday())) {
            throw AlreadySurveyException.EXCEPTION;
        }
    }
}
