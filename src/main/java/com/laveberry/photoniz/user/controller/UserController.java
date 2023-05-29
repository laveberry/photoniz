package com.laveberry.photoniz.user.controller;

import com.laveberry.photoniz.common.model.BasicResponse;
import com.laveberry.photoniz.user.domain.User;
import com.laveberry.photoniz.user.model.*;
import com.laveberry.photoniz.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signUp")
    public BasicResponse signUp(@RequestBody SignUpUserModel signUpUserModel) {
        User user = userService.signUp(signUpUserModel);
        return BasicResponse.toResponse(HttpStatus.ACCEPTED, user.getId());
    }

    @PostMapping("/signIn")
    public BasicResponse signIn(@RequestBody SignInModel signInUserModel) {
        SignInResultModel resultModel = userService.signIn(signInUserModel);
        return BasicResponse.toResponse(HttpStatus.OK, resultModel);
    }

    @GetMapping("/{email}")
    public BasicResponse userDetail(@PathVariable String email) {
        return BasicResponse.toResponse(HttpStatus.OK, userService.findUser(email));
    }

    @PutMapping("/{email}")
    public BasicResponse updateuser(@PathVariable String email, @RequestBody UpdateUserModel updateUserModel) {
        UpdateUserResultModel updateUserResultModel = userService.updateUser(email, updateUserModel);
        return BasicResponse.toResponse(HttpStatus.ACCEPTED, updateUserResultModel);
    }

}
