package com.laveberry.photoniz.admin.controller;

import com.laveberry.photoniz.config.Auth.AdminAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin")
public class AdminController {

    @GetMapping("/test")
    @AdminAuthorize
    public String test() {
        return "admin_test";
    }
}
