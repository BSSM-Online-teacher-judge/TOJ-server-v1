package com.toj.teacheronlinejudge.domain.teacher.domain;

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

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Comment> commentList= new ArrayList<>();

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
}
