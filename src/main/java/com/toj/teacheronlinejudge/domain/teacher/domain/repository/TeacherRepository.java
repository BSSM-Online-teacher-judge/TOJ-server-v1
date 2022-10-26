package com.toj.teacheronlinejudge.domain.teacher.domain.repository;

import com.toj.teacheronlinejudge.domain.teacher.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllByOrderByTierDesc();

    List<Teacher> findTop3ByOrderByTierDesc();

    List<Teacher> findAllByOrderByLikesDesc();
}
