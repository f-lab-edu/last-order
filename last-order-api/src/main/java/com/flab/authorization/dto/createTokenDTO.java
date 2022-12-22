package com.flab.authorization.dto;

import com.flab.user.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class createTokenDTO {
    private Long userId;
    private Role role;
}
