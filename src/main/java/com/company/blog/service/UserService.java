package com.company.blog.service;

import com.company.blog.data.dto.request.LoginRequestDto;
import com.company.blog.data.dto.request.RegisterRequestDto;
import com.company.blog.resource.JWTAuthResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    JWTAuthResponse login(LoginRequestDto loginRequestDto);
    ResponseEntity<String> register(RegisterRequestDto registerRequestDto);
}
