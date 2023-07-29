package com.laveberry.photoniz.user.controller;

import com.laveberry.photoniz.common.model.BasicResponse;
import com.laveberry.photoniz.user.domain.User;
import com.laveberry.photoniz.user.model.*;
import com.laveberry.photoniz.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "회원 가입", description = "회원 가입을 요청합니다.", tags = {"User Controller"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = BasicResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR"),
    })
    @PostMapping("/signUp")
    public BasicResponse signUp(@RequestBody @Validated SignUpModel signUpModel) {
        User user = userService.signUp(signUpModel);
        return BasicResponse.toResponse(HttpStatus.ACCEPTED, user.getId());
    }

    @Operation(summary = "로그인(토큰 생성)", description = "로그인을 합니다.", tags = {"User Controller"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = BasicResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR"),
    })
    @PostMapping("/signIn")
    public BasicResponse signIn(@RequestBody @Validated SignInModel signInUserModel) {
        SignInResultModel resultModel = userService.signIn(signInUserModel);
        return BasicResponse.toResponse(HttpStatus.OK, resultModel);
    }

    @Operation(summary = "유저 조회", description = "유저를 조회 합니다.", tags = {"User Controller"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = BasicResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR"),
    })
    @GetMapping
    public BasicResponse userDetail(@RequestParam String email) {
        return BasicResponse.toResponse(HttpStatus.OK, userService.findUser(email));
    }

    @Operation(summary = "사용자 정보 수정", description = "사용자를 수정 합니다.", tags = {"User Controller"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = BasicResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR"),
    })
    @PutMapping
    public BasicResponse updateUser(@RequestBody @Validated UpdateUserModel updateUserModel, @RequestHeader("Authorization") String token) {
        UpdateUserResultModel updateUserResultModel = userService.updateUser(updateUserModel, token);
        return BasicResponse.toResponse(HttpStatus.ACCEPTED, updateUserResultModel);
    }

}
