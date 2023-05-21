package com.laveberry.photoniz.user.repository;

import com.laveberry.photoniz.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{

    private final UserJpaRepository userJpaRepository;
    @Override
    public User findUser(String email) {
        Optional<User> user = userJpaRepository.findByEmail(email);
        System.out.println("user = " + user);
        return null;
    }
}
