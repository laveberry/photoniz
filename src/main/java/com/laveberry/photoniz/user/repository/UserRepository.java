package com.laveberry.photoniz.user.repository;

import com.laveberry.photoniz.user.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findUser(String email);

    User save(User user);

    void deleteUser(User user);

    Optional<User> findUserById(Integer userId);
}
