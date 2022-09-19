package com.toj.teacheronlinejudge.global.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public class BaseStatsEntity extends BaseTimeEntity{

    @Column(name = "humor", nullable = false)
    protected int humor;      // 유머

    @Column(name = "tenacity", nullable = false)
    protected int tenacity;   // 인성

    @Column(name = "expertise", nullable = false)
    protected int expertise;  // 전문성

    @Column(name = "fairness", nullable = false)
    protected int fairness;   // 공평성

    @Column(name = "snack_readiness", nullable = false)
    protected int snackReadiness;  // 간식 준비성

    @Column(name = "modesty", nullable = false)
    protected int modesty;    // 겸손

    @Column(name = "passion", nullable = false)
    protected int passion;    // 열정


    @Column(name = "stubborn", nullable = false)
    protected int stubborn;   // 고집

    @Column(name = "authoritarianism", nullable = false)
    protected int authoritarianism; // 권위주의

    @Column(name = "SUA", nullable = false)
    protected int sua;    // 급발진 정도
}
