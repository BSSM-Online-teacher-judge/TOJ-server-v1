package com.toj.teacheronlinejudge.domain.stats.service;

import com.toj.teacheronlinejudge.domain.stats.domain.Stats;
import com.toj.teacheronlinejudge.domain.stats.domain.Survey;
import com.toj.teacheronlinejudge.domain.stats.domain.repository.StatsRepository;
import com.toj.teacheronlinejudge.domain.stats.facade.StatsFacade;
import com.toj.teacheronlinejudge.domain.stats.presentation.dto.response.StatsResponseDto;
import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.teacher.facade.TeacherFacade;
import com.toj.teacheronlinejudge.domain.teacher.service.stats.StatsPolicy;
import com.toj.teacheronlinejudge.global.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final StatsRepository statsRepository;
    private final StatsFacade statsFacade;
    private final TeacherFacade teacherFacade;
    private final StatsPolicy statsPolicy;

    public void updateStats(Survey survey) {
        Stats stats = statsRepository.findByTeacherAndCreatedAtBetween(
                survey.getTeacher(),
                DateUtil.monthOfStart(),
                DateUtil.monthOfEnd()
        );

        if (stats == null) {
            stats = statsRepository.save(Stats.createStats(survey));
        } else {
            stats.update(survey);
        }

        statsPolicy.updateStats(stats.getTeacher(), survey);
    }

    @Transactional(readOnly = true)
    public StatsResponseDto findStats(Long teacherId) {
        Teacher teacher = teacherFacade.findTeacherById(teacherId);
        return StatsResponseDto.of(statsFacade.findStatsByTeacher(teacher));
    }
}
