package com.flab.user.dto.response;

import com.flab.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String email;
    private String name;
    private Integer age;

    public static UserResponse from(User user){
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getAge()
        );
    }
}
