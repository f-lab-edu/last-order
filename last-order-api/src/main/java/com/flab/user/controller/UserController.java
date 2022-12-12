package com.flab.user.controller;

import com.flab.user.dto.request.LoginRequest;
import com.flab.user.dto.request.SignupRequest;
import com.flab.user.dto.response.UserResponse;
import com.flab.user.service.UserService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public void login(@Valid @RequestBody LoginRequest login) {
        userService.login(login);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@Valid @RequestBody SignupRequest request) {
        userService.signUp(request);
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

}

