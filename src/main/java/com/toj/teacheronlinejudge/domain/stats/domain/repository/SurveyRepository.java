package com.toj.teacheronlinejudge.domain.stats.domain.repository;

import com.toj.teacheronlinejudge.domain.stats.domain.Survey;
import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import com.toj.teacheronlinejudge.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

    boolean existsByUserAndTeacherAndCreatedAtAfter(User user, Teacher teacher, LocalDateTime today);
}
