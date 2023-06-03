package com.laveberry.photoniz.user.service;

import com.laveberry.photoniz.common.BaseSpringBootTest;
import com.laveberry.photoniz.user.domain.Address;
import com.laveberry.photoniz.user.model.SignUpUserModel;
import com.laveberry.photoniz.user.domain.User;
import com.laveberry.photoniz.user.repository.UserJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("유저 서비스")
public class UserServiceTest extends BaseSpringBootTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserJpaRepository userRepository;


    @Test
    @DisplayName("유저 생성")
    void saveUser() {

        SignUpUserModel signUpUserModel =
                new SignUpUserModel("test@gmail.com", "테스트유저", "테스트닉네임", "123123123", "01012345678", new Address("인서울", "한강아파트", ""));

        User user = userService.signUp(signUpUserModel);

        String email = userRepository.save(user).getEmail();

        assertThat(email).isEqualTo("test@gmail.com");
    }

    @Test
    @DisplayName("유저 조회")
    void findUser() {

        //given
        String email = "test@test.com";

        //when
        User user = userRepository.findByEmail(email).get();

        //then
        assertThat(user.getName()).isEqualTo("test");
    }

    @Test
    @DisplayName("Querydsl로 유저 조회")
    void findUserList() {

        List<User> users = userRepository.findUserByName("test");

        assertAll(
                () -> assertThat(users.get(0).getName()).isEqualTo("test"),
                () -> assertThat(users.get(1).getName()).isEqualTo("test")
        );

    }
}
