package com.flab.user.controller;

import com.flab.user.domain.User;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public LoginDTO login(@RequestBody LoginDTO login) {
        return login;
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        return user;
    }

    @GetMapping("/duplicate/{email}")
    public Boolean checkDuplicate(@PathVariable String email) {
        User user = new User("flab@google.com", "ji",28);

        return user.getEmail().equals(email);
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @Getter
    @Setter
    private static class LoginDTO {
        @NonNull
        private String id;
        @NonNull
        private String pw;
    }
}
