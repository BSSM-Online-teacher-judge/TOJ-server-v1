package com.toj.teacheronlinejudge.domain.teacher.domain.repository;

import com.toj.teacheronlinejudge.domain.teacher.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
