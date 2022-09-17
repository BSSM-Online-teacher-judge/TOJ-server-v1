package com.toj.teacheronlinejudge.domain.teacher.domain.repository;

import com.toj.teacheronlinejudge.domain.teacher.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
