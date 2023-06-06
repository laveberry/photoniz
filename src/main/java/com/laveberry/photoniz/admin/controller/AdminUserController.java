package com.laveberry.photoniz.admin.controller;

import com.laveberry.photoniz.admin.service.AdminUserService;
import com.laveberry.photoniz.common.model.BasicResponse;
import com.laveberry.photoniz.config.Auth.AdminAuthorize;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/admin")
public class AdminUserController {

    private final AdminUserService adminUserService;

    @DeleteMapping("/user")
    @AdminAuthorize
    public BasicResponse deleteUser(@RequestParam String email) {
        adminUserService.deleteUser(email);
        return BasicResponse.toResponse(HttpStatus.OK, email);
    }
}
