package com.company.blog.controller;

import com.company.blog.data.dto.request.LoginRequestDto;
import com.company.blog.data.dto.request.RegisterRequestDto;
import com.company.blog.resource.JWTAuthResponse;
import com.company.blog.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @ApiOperation(value = "REST API to Register or Signup user to Blog app")
    @PostMapping("/sign-in")
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(userService.login(loginRequestDto));
    }

    @ApiOperation(value = "REST API to Signin or Login user to Blog app")
    @PostMapping("/sign-up")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto registerRequestDto) {
        return userService.register(registerRequestDto);
    }
}
