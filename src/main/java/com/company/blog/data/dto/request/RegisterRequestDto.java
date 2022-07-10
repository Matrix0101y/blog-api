package com.company.blog.data.dto.request;

import lombok.Data;

@Data
public class RegisterRequestDto {
    private String name;
    private String username;
    private String email;
    private String password;
}
