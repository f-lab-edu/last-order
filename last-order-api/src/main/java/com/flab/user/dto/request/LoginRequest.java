package com.flab.user.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class LoginRequest {
    @NotBlank(message = "{NotBlank.loginRequest.email}")
    private String email;
    @NotBlank(message = "{NotBlank.loginRequest.password}")
    private String password;
}
