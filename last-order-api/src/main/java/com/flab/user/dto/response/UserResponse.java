package com.flab.user.dto.response;

import com.flab.user.domain.User;
import com.flab.user.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponse {
    private Long id;
    private String email;
    private String name;
    private Integer age;
    private Role role;

    public static UserResponse from(User user){
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getAge(),
                user.getRole()
        );
    }
}
