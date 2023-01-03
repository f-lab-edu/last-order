package com.flab.config.jwt;

import com.flab.user.domain.User;
import com.flab.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository memberRepository;

    @Override
    @Cacheable(value = CacheKey.USER, key = "#email", unless = "#result == null")
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User member = memberRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("없는 회원입니다."));
        return CustomUserDetails.of(member);
    }
}
