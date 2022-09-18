package com.toj.teacheronlinejudge.domain.stats.domain;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.user.domain.User;
import com.toj.teacheronlinejudge.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "survey_tbl")
public class Survey extends BaseTimeEntity {

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

    private int humor;      // 유머
    private int tenacity;   // 인성
    private int expertise;  // 전문성
    private int fairness;   // 공평성
    private int snackReadiness;  // 간식 준비성
    private int modesty;    // 겸손
    private int passion;    // 열정

    private int stubborn;   // 고집
    private int authoritarianism; // 권위주의
    private int SUA;    // 급발진 정도

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
