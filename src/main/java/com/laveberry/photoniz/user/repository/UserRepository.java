package com.laveberry.photoniz.user.repository;

import com.laveberry.photoniz.user.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findUser(String email);

    User save(User user);
}
