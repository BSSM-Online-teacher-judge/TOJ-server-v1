package com.toj.teacheronlinejudge.domain.ad.domain.repository;

import com.toj.teacheronlinejudge.domain.ad.domain.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {

    List<Ad> findAllByOrderByIdDesc();
}
