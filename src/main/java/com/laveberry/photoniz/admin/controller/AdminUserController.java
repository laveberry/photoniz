package com.laveberry.photoniz.admin.controller;

import com.laveberry.photoniz.admin.service.AdminUserService;
import com.laveberry.photoniz.common.model.BasicResponse;
import com.laveberry.photoniz.config.Auth.AdminAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/admin")
public class AdminUserController {

    private final AdminUserService adminUserService;

    @Operation(summary = "사용자 삭제", description = "사용자를 삭제합니다(ADMIN)", tags = {"Admin Controller"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = BasicResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR"),
    })
    @DeleteMapping("/user")
    @AdminAuthorize
    public BasicResponse deleteUser(@RequestParam String email) {
        adminUserService.deleteUser(email);
        return BasicResponse.toResponse(HttpStatus.OK, email);
    }
}
