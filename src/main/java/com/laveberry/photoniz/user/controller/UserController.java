package com.laveberry.photoniz.user.controller;

import com.laveberry.photoniz.common.model.BasicResponse;
import com.laveberry.photoniz.user.domain.SignUpUserModel;
import com.laveberry.photoniz.user.model.User;
import com.laveberry.photoniz.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public BasicResponse signUp(SignUpUserModel signUpUserModel) {
        log.info("Sign Up User : {}", signUpUserModel);
        User user = userService.signUp(signUpUserModel);
        return BasicResponse.toResponse(HttpStatus.ACCEPTED, user.getId());
    }

}
