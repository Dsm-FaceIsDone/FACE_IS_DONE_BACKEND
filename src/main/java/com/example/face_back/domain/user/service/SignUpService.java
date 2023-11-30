package com.example.face_back.domain.user.service;

import com.example.face_back.domain.user.domain.RefreshToken;
import com.example.face_back.domain.user.domain.User;
import com.example.face_back.domain.user.domain.repository.RefreshTokenRepository;
import com.example.face_back.domain.user.domain.repository.UserRepository;
import com.example.face_back.domain.user.presentation.dto.request.SignUpRequest;
import com.example.face_back.domain.user.presentation.dto.response.TokenResponse;
import com.example.face_back.domain.user.service.exception.AccountIdAlreadyExistException;
import com.example.face_back.global.config.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse userSignUp(SignUpRequest request) {
        if (userRepository.existsByUserId(request.getUserId())) {
            throw new AccountIdAlreadyExistException();
        }

        User user = userRepository.save(User.builder()
                .userId(request.getUserId())
                .password(passwordEncoder.encode(request.getPassword()))
                .nickname(request.getNickname())
                .build());

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(user.getUserId()))
                .refreshToken(refreshTokenRepository.save(RefreshToken.builder()
                        .userId(user.getUserId())
                        .refreshToken(jwtTokenProvider.generateRefreshToken(user.getUserId()))
                        .build()).getRefreshToken())
                .build();
    }
}
