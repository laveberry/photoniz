package com.laveberry.photoniz.user.service;

import com.laveberry.photoniz.common.BaseSpringBootTest;
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
        User user = User.builder()
                .name("test")
                .user_role(Role.ADMIN)
                .address("주소")
                .phone("01012345678")
                .password("password")
                .email("test@test.com")
                .build();

        String email = userRepository.save(user).getEmail();

        assertThat(email).isEqualTo("test@test.com");
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
