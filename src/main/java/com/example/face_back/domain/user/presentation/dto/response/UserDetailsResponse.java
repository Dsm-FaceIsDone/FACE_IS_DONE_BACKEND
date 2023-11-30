package com.example.face_back.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDetailsResponse {
    private final String nickname;
    private final String userId;
    private final String profileImgUrl;
    private final long totalPosts;
}