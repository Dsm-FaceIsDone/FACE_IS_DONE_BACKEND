package com.example.face_back.domain.user.service.util;

import com.example.face_back.domain.user.domain.User;
import com.example.face_back.domain.user.domain.repository.UserRepository;
import com.example.face_back.domain.user.service.exception.UserNotFoundException;
import com.example.face_back.global.config.security.jwt.exception.TokenUnauthorizedException;
import com.example.face_back.infra.aws.service.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class UserUtil {
    private final UserRepository userRepository;
    private final S3Util s3Util;

    public String getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) throw TokenUnauthorizedException.EXCEPTION;
        return authentication.getName();
    }

    public User getUser() {
        return userRepository.findById(getUserId()).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void upload(String userId, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            User user = userRepository.findByUserId(userId)
                    .orElseThrow(() -> UserNotFoundException.EXCEPTION);
            user.updatePath(s3Util.upload(file));
        }
    }
}
