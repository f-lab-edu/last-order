package com.flab.user.controller;

import com.flab.authorization.dto.createTokenDTO;
import com.flab.authorization.service.AuthorizationService;
import com.flab.user.domain.User;
import com.flab.user.dto.request.LoginRequest;
import com.flab.user.dto.request.SignupRequest;
import com.flab.user.dto.response.UserResponse;
import com.flab.user.service.UserService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final AuthorizationService authorizationService;

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest login) {
        UserResponse user = userService.login(login);

//        String token = authorizationService.createToken(new createTokenDTO(user.getId(),user.getRole()));
        return "success";
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@Valid @RequestBody SignupRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .name(request.getName())
                .age(request.getAge())
                .authorities(request.getAuthorities())
                .build();

        userService.signUp(user);
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

}

