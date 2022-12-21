package com.flab.user.service;


import com.flab.user.domain.User;
import com.flab.user.dto.request.LoginRequest;
import com.flab.user.dto.request.SignupRequest;
import com.flab.user.dto.response.UserResponse;
import com.flab.user.encoder.Encryptor;
import com.flab.user.exception.EmailAlreadyExistException;
import com.flab.user.exception.EmailNotExistException;
import com.flab.user.exception.PasswordNotMatchException;
import com.flab.user.repository.JpaAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final JpaAccountRepository userRepository;
    private final Encryptor encryptor;

    public void signUp(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistException();
        }
        user.setPassword(encryptor.encoder(user.getPassword()));
        userRepository.save(user);
    }

    public UserResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> {
            throw new EmailNotExistException();
        });
        if (!encryptor.checkPassword(request.getPassword(), user.getPassword())) {
            throw new PasswordNotMatchException();
        }
        return UserResponse.from(user);
    }
}
