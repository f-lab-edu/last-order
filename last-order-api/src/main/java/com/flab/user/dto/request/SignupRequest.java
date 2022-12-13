package com.flab.user.dto.request;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class SignupRequest {

    @NotBlank(message = "{NotBlank.signupRequest.email}")
    @Email(message = "{Email.signupRequest.email}")
    private String email;

    @NotBlank(message = "{NotBlank.signupRequest.password}")
    private String password;

    @NotBlank(message = "{NotBlank.signupRequest.name}")
    private String name;

    @NotNull(message = "{NotNull.signupRequest.age}")
    @Range(min = 0, max = 120, message = "{Range.signupRequest.age}")
    private Integer age;
}
