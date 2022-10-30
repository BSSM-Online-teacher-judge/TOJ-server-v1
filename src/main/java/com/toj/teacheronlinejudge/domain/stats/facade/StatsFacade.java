package com.toj.teacheronlinejudge.domain.stats.facade;

import com.toj.teacheronlinejudge.domain.stats.domain.Stats;
import com.toj.teacheronlinejudge.domain.stats.domain.Survey;
import com.toj.teacheronlinejudge.domain.stats.domain.repository.StatsRepository;
import com.toj.teacheronlinejudge.domain.stats.exception.StatsNotFoundException;
import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.teacher.service.stats.StatsPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StatsFacade {

    private final StatsRepository statsRepository;
    private final StatsPolicy statsPolicy;

    public Stats findStatsByTeacher(Teacher teacher) {
        return statsRepository.findByTeacher(teacher)
                .orElseThrow(() -> StatsNotFoundException.EXCEPTION);
    }

    public void updateStats(Teacher teacher, Survey survey) {
        statsPolicy.calculateStats(teacher, survey);
    }
}
