package com.laveberry.photoniz.user.repository;

import com.laveberry.photoniz.user.domain.User;

import java.util.List;

public interface QUserRepository {

    List<User> findUserByName(String name);

}
