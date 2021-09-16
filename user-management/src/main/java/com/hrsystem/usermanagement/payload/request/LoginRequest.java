package com.hrsystem.usermanagement.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
    private boolean isRememberMe;
}
