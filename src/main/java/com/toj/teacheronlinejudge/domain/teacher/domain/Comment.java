package com.toj.teacheronlinejudge.domain.teacher.domain;

import com.toj.teacheronlinejudge.domain.user.domain.User;
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
@Table(name = "comment_tbl")
public class Comment extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Comment parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Comment> children = new ArrayList<>();

    public static Comment createComment(String content, Teacher teacher, User user) {
        Comment comment = new Comment();

        comment.content = content;
        comment.teacher = teacher;
        comment.user = user;
        teacher.getCommentList().add(comment);
        user.getCommentList().add(comment);

        return comment;
    }

    public Comment setParent(Comment comment) {
        this.parent = comment;
        comment.getChildren().add(this);
        return this;
    }
}
