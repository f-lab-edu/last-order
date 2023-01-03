package com.flab.user.domain;

import com.flab.config.jwt.Authority;
import com.flab.user.domain.enums.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_ID")
    private Long id;
    @Email
    private String email;

    private String password;

    private String name;

    private Integer age;

    @OneToMany(mappedBy = "user", cascade = ALL, orphanRemoval = true)
    @Builder.Default
    private Set<Authority> authorities = new HashSet<>();

    public List<String> getRoles() {
        return authorities.stream()
                .map(Authority::getRole)
                .collect(toList());
    }
}
