package com.laveberry.photoniz.user.repository;

import com.laveberry.photoniz.user.model.User;

public interface UserRepository {
    User findUser(String email);
}
