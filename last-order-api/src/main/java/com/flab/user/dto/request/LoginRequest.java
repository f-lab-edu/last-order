package com.flab.user.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class LoginRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
