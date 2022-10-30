package com.toj.teacheronlinejudge.domain.teacher.policy.stats;

import com.toj.teacheronlinejudge.domain.stats.domain.Survey;
import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;

public interface StatsPolicy {

    void calculateStats(Teacher teacher, Survey survey);
}
