package com.toj.teacheronlinejudge.domain.user.domain.repository;

import com.toj.teacheronlinejudge.domain.user.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailAndNickName(String email, String nickName);

    Optional<User> findByEmail(String email);

    @EntityGraph(attributePaths = "commentList")
    @Query("select u from User u where u.id = :id")
    Optional<User> findUserWithComment(Long id);

    @EntityGraph(attributePaths = "surveyList")
    @Query("select u from User u where u.id = :id")
    Optional<User> findUserWithSurvey(Long id);
}
