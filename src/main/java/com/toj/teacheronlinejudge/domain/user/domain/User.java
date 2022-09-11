package com.toj.teacheronlinejudge.domain.user.domain;

import com.toj.teacheronlinejudge.domain.teacher.domain.Comment;
import com.toj.teacheronlinejudge.domain.user.domain.type.Authority;
import com.toj.teacheronlinejudge.global.entity.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "user_tbl")
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = false)
    private Long id;

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
}
