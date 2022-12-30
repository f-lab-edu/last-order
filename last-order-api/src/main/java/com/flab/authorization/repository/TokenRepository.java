package com.flab.authorization.repository;

import com.flab.authorization.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, String> {
}
