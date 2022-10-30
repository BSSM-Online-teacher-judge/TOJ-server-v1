package com.toj.teacheronlinejudge.domain.teacher.service.stats;

import com.toj.teacheronlinejudge.domain.stats.domain.Survey;
import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;

public interface StatsPolicy {

    void updateStats(Teacher teacher, Survey survey);
}
