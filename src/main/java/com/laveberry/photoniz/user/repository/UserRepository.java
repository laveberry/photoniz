package com.laveberry.photoniz.user.repository;

import com.laveberry.photoniz.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository {
    User findUser(String email);
}
