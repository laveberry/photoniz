package com.laveberry.photoniz.sample.service;

import com.laveberry.photoniz.common.BaseSpringBootTest;
import com.laveberry.photoniz.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


public class ServiceTest extends BaseSpringBootTest {

    @Autowired
    private UserService userService;

    @Test
    void 회원가입서비스() {
        String user = userService.join("user@naver.com", "사람", "1234");
        assertThat(user).isEqualTo("사람");
    }
}
