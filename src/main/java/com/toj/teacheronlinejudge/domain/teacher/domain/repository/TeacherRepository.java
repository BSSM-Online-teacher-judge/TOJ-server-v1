package com.toj.teacheronlinejudge.domain.teacher.domain.repository;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
