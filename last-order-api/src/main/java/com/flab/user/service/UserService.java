package com.flab.user.service;

import com.flab.user.domain.User;
import com.flab.user.dto.LoginRequest;

public interface UserService {
    User signUp(User user);
    LoginRequest login(LoginRequest login);
}
