package com.toj.teacheronlinejudge.domain.teacher.service.stats;

import com.toj.teacheronlinejudge.domain.stats.domain.Survey;
import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import org.springframework.stereotype.Component;

@Component
public class StatsPolicyImpl implements StatsPolicy {
    
    @Override
    public void calculateStats(Teacher teacher, Survey survey) {

        // TODO :: 간식 준비성 오버롤에 포함할지 논의 필요
        // TODO :: 티어 논의 필요

        int positive =
            survey.getExpertise()
                + survey.getFairness()
                + survey.getHumor()
                + survey.getModesty()
                + survey.getPassion()
                + survey.getTenacity();

        int negative =
            survey.getAuthoritarianism()
                + survey.getStubborn()
                + survey.getSua();

        int tier = calcTier(teacher, positive, negative);

        teacher.updateTier(tier);
    }

    private int calcTier(Teacher teacher, int positive, int negative) {
        int surveyTier = positive - (negative*2) / 6;
        return (teacher.getTier() + surveyTier) / 2;
    }
}
