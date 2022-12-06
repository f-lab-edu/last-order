package com.flab.user.controller;

import com.flab.user.domain.User;
import com.flab.user.dto.LoginRequest;
import com.flab.user.service.UserService;
import lombok.*;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public LoginRequest login(@RequestBody LoginRequest login) {
        userService.login(login);
        return login;
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        userService.signUp(user);
        return user;
    }
    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

}

