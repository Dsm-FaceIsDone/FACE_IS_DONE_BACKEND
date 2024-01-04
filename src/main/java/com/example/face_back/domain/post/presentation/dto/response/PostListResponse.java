package com.example.face_back.domain.post.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class PostListResponse {
    private final int totalPosts;
    private final List<PostResponse> postResponses;

    @Getter
    @Builder
    public static class PostResponse {
        private final Long id;
        private final String userId;
        private final String nickname;
        private final String content;
        private final String profileImage;
        private final Integer heartCount;
    }
}
