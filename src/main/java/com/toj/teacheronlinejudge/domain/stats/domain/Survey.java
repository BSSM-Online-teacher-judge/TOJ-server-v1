package com.toj.teacheronlinejudge.domain.stats.domain;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.user.domain.User;
import com.toj.teacheronlinejudge.global.entity.BaseStatsEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "survey_tbl")
public class Survey extends BaseStatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Survey(Teacher teacher, User user, int humor, int tenacity, int expertise, int fairness, int snackReadiness, int modesty, int passion, int stubborn, int authoritarianism, int SUA) {
        this.teacher = teacher;
        this.user = user;
        this.humor = humor;
        this.tenacity = tenacity;
        this.expertise = expertise;
        this.fairness = fairness;
        this.snackReadiness = snackReadiness;
        this.modesty = modesty;
        this.passion = passion;
        this.stubborn = stubborn;
        this.authoritarianism = authoritarianism;
        this.SUA = SUA;
    }

    public void setRelation(Teacher teacher, User user) {
        this.teacher = teacher;
        teacher.getSurveyList().add(this);
        this.user = user;
        user.getSurveyList().add(this);
    }
}
