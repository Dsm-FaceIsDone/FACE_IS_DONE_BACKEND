package com.example.face_back.domain.user.service;

import com.example.face_back.domain.user.domain.RefreshToken;
import com.example.face_back.domain.user.domain.repository.RefreshTokenRepository;
import com.example.face_back.domain.user.service.exception.RefreshTokenNotFound;
import com.example.face_back.domain.user.service.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class LogOutService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserUtil userUtil;

    public void logOut() {
        RefreshToken refreshToken = refreshTokenRepository.findById(userUtil.getUserId())
                .orElseThrow(() -> RefreshTokenNotFound.EXCEPTION);

        refreshTokenRepository.delete(refreshToken);
    }
}
