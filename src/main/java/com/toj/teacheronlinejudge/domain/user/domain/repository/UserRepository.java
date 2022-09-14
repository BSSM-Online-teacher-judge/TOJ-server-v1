package com.toj.teacheronlinejudge.domain.user.domain.repository;

import com.toj.teacheronlinejudge.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailAndNickName(String email, String nickName);

    Optional<User> findByEmail(String email);
}
