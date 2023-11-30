package com.example.face_back.domain.user.service.util;

import com.example.face_back.domain.user.domain.User;
import com.example.face_back.domain.user.domain.repository.UserRepository;
import com.example.face_back.domain.user.service.exception.UserNotFoundException;
import com.example.face_back.global.config.security.jwt.exception.TokenUnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtil {
    private final UserRepository userRepository;

    public String getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) throw TokenUnauthorizedException.EXCEPTION;
        return authentication.getName();
    }

    public User getUser() {
        return userRepository.findById(getUserId()).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
