package com.laveberry.photoniz.user.repository;

import com.laveberry.photoniz.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
