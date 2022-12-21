package com.flab.authorization.service;

import com.flab.authorization.domain.Token;
import com.flab.authorization.dto.createTokenDTO;
import com.flab.authorization.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final TokenRepository tokenRepository;

    public String createToken(createTokenDTO tokenInfo) {
        String tokenId = UUID.randomUUID().toString();

        Token token = new Token(tokenId,
                tokenInfo.getUserId(),
                tokenInfo.getRole()
        );

        tokenRepository.save(token);

        return tokenId;
    }
}
