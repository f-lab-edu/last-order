package com.flab.authorization.domain;

import com.flab.user.domain.enums.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_token")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Token {
    @Id
    String token;
    Long userId;
    Role role;
}
