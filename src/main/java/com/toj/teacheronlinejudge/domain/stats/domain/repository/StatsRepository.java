package com.toj.teacheronlinejudge.domain.stats.domain.repository;

import com.toj.teacheronlinejudge.domain.stats.domain.Stats;
import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface StatsRepository extends JpaRepository<Stats, Long> {

    Stats findByTeacherAndCreatedAtBetween(Teacher teacher, LocalDateTime start, LocalDateTime end);

    Optional<Stats> findByTeacher(Teacher teacherById);
}
