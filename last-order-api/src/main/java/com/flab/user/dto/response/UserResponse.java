package com.flab.user.dto.response;

import com.flab.config.jwt.Authority;
import com.flab.user.domain.User;
import com.flab.user.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
public class UserResponse {
    private Long id;
    private String email;
    private String name;
    private Integer age;
    private Set<Authority> authorities = new HashSet<>();

    public static UserResponse from(User user){
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getAge(),
                user.getAuthorities()
        );
    }
}
