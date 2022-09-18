package com.toj.teacheronlinejudge.domain.stats.service;

import com.toj.teacheronlinejudge.domain.stats.domain.Stats;
import com.toj.teacheronlinejudge.domain.stats.domain.Survey;
import com.toj.teacheronlinejudge.domain.stats.domain.repository.StatsRepository;
import com.toj.teacheronlinejudge.global.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final StatsRepository statsRepository;

    public void updateStats(Survey survey) {
        Stats stats = statsRepository.findByTeacherAndCreatedAtBetween(
                survey.getTeacher(),
                DateUtil.monthOfStart(),
                DateUtil.monthOfEnd()
        );

        if (stats == null) {
            statsRepository.save(Stats.createStats(survey));
        } else {
            stats.update(survey);
        }
    }
}
