package com.flab.user.repository;

import com.flab.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAccountRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
