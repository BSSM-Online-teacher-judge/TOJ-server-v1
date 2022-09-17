package com.toj.teacheronlinejudge.domain.teacher.domain.repository;

import com.toj.teacheronlinejudge.domain.teacher.domain.Survey;
import com.toj.teacheronlinejudge.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

    boolean existsByUserAndCreatedAtAfter(User user, LocalDateTime today);
}
