package com.toj.teacheronlinejudge.domain.stats.domain;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.global.entity.BaseStatsEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "stats_tbl")
public class Stats extends BaseStatsEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Builder
    public Stats(Teacher teacher, int humor, int tenacity, int expertise, int fairness, int snackReadiness, int modesty, int passion, int stubborn, int authoritarianism, int sua) {
        this.teacher = teacher;
        this.humor = humor;
        this.tenacity = tenacity;
        this.expertise = expertise;
        this.fairness = fairness;
        this.snackReadiness = snackReadiness;
        this.modesty = modesty;
        this.passion = passion;
        this.stubborn = stubborn;
        this.authoritarianism = authoritarianism;
        this.sua = sua;
    }

    public static Stats createStats(Survey survey) {
        Stats stats = Stats.builder()
                .teacher(survey.getTeacher())
                .humor(survey.getHumor())
                .tenacity(survey.getTenacity())
                .expertise(survey.getExpertise())
                .fairness(survey.getFairness())
                .snackReadiness(survey.getSnackReadiness())
                .modesty(survey.getModesty())
                .passion(survey.getPassion())
                .stubborn(survey.getStubborn())
                .authoritarianism(survey.getAuthoritarianism())
                .sua(survey.getSua())
                .build();

        survey.getTeacher().getStatsList().add(stats);

        return stats;
    }

    public void update(Survey survey) {
        this.humor = (this.humor + survey.getHumor()) / 2;
        this.tenacity = (this.tenacity + survey.getTenacity()) / 2;
        this.expertise = (this.expertise + survey.getExpertise()) / 2;
        this.fairness = (this.fairness + survey.getFairness()) / 2;
        this.snackReadiness = (this.snackReadiness + survey.getSnackReadiness()) / 2;
        this.modesty = (this.modesty + survey.getModesty()) / 2;
        this.passion = (this.passion + survey.getPassion()) / 2;
        this.stubborn = (this.stubborn + survey.getStubborn()) / 2;
        this.authoritarianism = (this.authoritarianism + survey.getAuthoritarianism()) / 2;
        this.sua = (this.sua + survey.getSua()) / 2;
    }
}
