package com.laveberry.photoniz.user.service;

import com.laveberry.photoniz.common.BaseSpringBootTest;
import com.laveberry.photoniz.user.domain.SignUpUserModel;
import com.laveberry.photoniz.user.enums.Role;
import com.laveberry.photoniz.user.model.User;
import com.laveberry.photoniz.user.repository.UserJpaRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
                new SignUpUserModel("test@gmail.com", "테스트유저", "1234", "123123123", "서울");

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
}
