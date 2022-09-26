package com.toj.teacheronlinejudge.domain.teacher.domain;

import com.toj.teacheronlinejudge.domain.user.domain.User;
import com.toj.teacheronlinejudge.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "like_tbl")
public class Like extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public static Like createLike(Teacher teacher, User user) {
        Like like = new Like();

        like.teacher = teacher;
        teacher.getLikes().add(like);

        like.user = user;
        user.getLikes().add(like);

        return like;
    }
}
