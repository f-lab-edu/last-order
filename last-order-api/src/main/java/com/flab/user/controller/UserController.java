package com.flab.user.controller;

import com.flab.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/user")
    public String test(){
        User user = new User("코린이", 25);
        return user.toString();
    }
}
