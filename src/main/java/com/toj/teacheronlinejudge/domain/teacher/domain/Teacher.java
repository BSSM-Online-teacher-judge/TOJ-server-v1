package com.toj.teacheronlinejudge.domain.teacher.domain;

import com.toj.teacheronlinejudge.domain.stats.domain.Stats;
import com.toj.teacheronlinejudge.domain.stats.domain.Survey;
import com.toj.teacheronlinejudge.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "teacher_tbl")
public class Teacher extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "profile_img", nullable = false)
    private String profileImg;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "tier", nullable = false)
    private int tier;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Comment> commentList= new ArrayList<>();

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Survey> surveyList = new ArrayList<>();

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Stats> statsList = new ArrayList<>();

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    @Builder
    public Teacher(String profileImg, String name, String description) {
        this.profileImg = profileImg;
        this.name = name;
        this.description = description;
    }

    public void updateTeacher(String profileImg, String name, String description) {
        this.profileImg = profileImg;
        this.name = name;
        this.description = description;
    }

    public void updateTier(Survey survey) {

        // TODO :: 간식 준비성 오버롤에 포함할지 논의 필요
        // TODO :: 티어 공식 논의 필요
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

        this.tier += (positive - (negative*2)) / 6;
    }
}
