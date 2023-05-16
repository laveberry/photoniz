package com.laveberry.photoniz.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    @Override
    public String join(String email, String name, String password) {
        return name;
    }
}
