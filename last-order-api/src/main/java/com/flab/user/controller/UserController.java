package com.flab.user.controller;

import com.flab.user.domain.User;
import com.flab.user.dto.request.LoginRequest;
import com.flab.user.service.impl.UserServiceImpl;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/login")
    public ResponseEntity<LoginRequest> login(@RequestBody LoginRequest login) {
        return new ResponseEntity<>(userService.login(login), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody User user) {
        return new ResponseEntity<>(userService.signUp(user),HttpStatus.CREATED);
    }
    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

}

