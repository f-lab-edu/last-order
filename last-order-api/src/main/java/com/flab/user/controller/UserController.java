package com.flab.user.controller;

import com.flab.user.domain.User;
import com.flab.user.dto.request.LoginRequest;
import com.flab.user.dto.request.SignupRequest;
import com.flab.user.dto.response.UserResponse;
import com.flab.user.service.impl.UserServiceImpl;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@Valid @RequestBody LoginRequest login) {
        return new ResponseEntity<>(userService.login(login), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signUp(@Valid @RequestBody SignupRequest request) {
        return new ResponseEntity<>(userService.signUp(request),HttpStatus.CREATED);
    }
    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

}

