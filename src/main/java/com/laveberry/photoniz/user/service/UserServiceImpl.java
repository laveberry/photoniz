package com.laveberry.photoniz.user.service;

import com.laveberry.photoniz.user.model.User;
import com.laveberry.photoniz.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String join(String email, String name, String password) {
        return name;
    }

    @Override
    public User findUser(String email) {
        return userRepository.findUser(email);
    }
}
