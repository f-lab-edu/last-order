package com.flab.user.service;

import com.flab.user.domain.User;
import com.flab.user.dto.request.LoginRequest;
import com.flab.user.dto.request.SignupRequest;
import com.flab.user.dto.response.UserResponse;

public interface UserService {
    UserResponse signUp(SignupRequest request);
    UserResponse login(LoginRequest login);
}
