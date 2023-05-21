package com.laveberry.photoniz.user.service;


import com.laveberry.photoniz.user.model.User;

public interface UserService {

    String join(String email, String name, String password);

    User findUser(String email);
}
