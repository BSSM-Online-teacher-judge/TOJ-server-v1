package com.toj.teacheronlinejudge.domain.user.domain;

import com.toj.teacheronlinejudge.domain.teacher.domain.Comment;
import com.toj.teacheronlinejudge.domain.stats.domain.Survey;
import com.toj.teacheronlinejudge.domain.user.domain.type.Authority;
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
@Table(name = "user_tbl")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickName", nullable = false, unique = true)
    private String nickName;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "grade", nullable = false)
    private int grade;

    @Column(name = "classRoom", nullable = false)
    private int classRoom;

    @Column(name = "authority", nullable = false)
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Survey> surveyList = new ArrayList<>();

    @Builder
    public User(String email, String password, String nickName, String name, int grade, int classRoom, Authority authority) {
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.name = name;
        this.grade = grade;
        this.classRoom = classRoom;
        this.authority = authority;
    }
}
