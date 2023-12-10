package com.example.face_back.domain.user.service;

import com.example.face_back.domain.user.domain.RefreshToken;
import com.example.face_back.domain.user.domain.User;
import com.example.face_back.domain.user.domain.repository.RefreshTokenRepository;
import com.example.face_back.domain.user.domain.repository.UserRepository;
import com.example.face_back.domain.user.presentation.dto.request.LogInRequest;
import com.example.face_back.domain.user.presentation.dto.response.TokenResponse;
import com.example.face_back.domain.user.service.exception.PasswordMisMatchException;
import com.example.face_back.domain.user.service.exception.UserNotFoundException;
import com.example.face_back.global.config.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogInService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    public TokenResponse userLogIn(LogInRequest request) {
        User user = userRepository.findByUserId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(user.getUserId()))
                .refreshToken(refreshTokenRepository.save(RefreshToken.builder()
                        .userId(user.getUserId())
                        .refreshToken(jwtTokenProvider.generateRefreshToken(user.getUserId()))
                        .build()).getRefreshToken())
                .build();
    }
}