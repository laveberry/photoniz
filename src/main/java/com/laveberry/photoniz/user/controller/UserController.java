package com.laveberry.photoniz.user.controller;

import com.laveberry.photoniz.common.model.BasicResponse;
import com.laveberry.photoniz.user.domain.User;
import com.laveberry.photoniz.user.model.*;
import com.laveberry.photoniz.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signUp")
    public BasicResponse signUp(@RequestBody @Validated SignUpModel signUpModel) {
        User user = userService.signUp(signUpModel);
        return BasicResponse.toResponse(HttpStatus.ACCEPTED, user.getId());
    }

    @PostMapping("/signIn")
    public BasicResponse signIn(@RequestBody @Validated SignInModel signInUserModel) {
        SignInResultModel resultModel = userService.signIn(signInUserModel);
        return BasicResponse.toResponse(HttpStatus.OK, resultModel);
    }

    @GetMapping
    public BasicResponse userDetail(@RequestParam String email) {
        return BasicResponse.toResponse(HttpStatus.OK, userService.findUser(email));
    }

    @PutMapping
    public BasicResponse updateUser(@RequestBody @Validated UpdateUserModel updateUserModel, @RequestHeader("Authorization") String token) {
        UpdateUserResultModel updateUserResultModel = userService.updateUser(updateUserModel, token);
        return BasicResponse.toResponse(HttpStatus.ACCEPTED, updateUserResultModel);
    }

}
