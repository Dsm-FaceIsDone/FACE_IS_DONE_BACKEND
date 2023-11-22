package com.example.face_back.domain.post.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponse {
    private final Long id;
    private final String userId;
    private final String nickname;
    private final String content;
    private final String file;
    private final Integer heartCount;

    @Builder
    private PostResponse(Long id, String userId, String nickname, String content, String file, Integer heartCount){
        this.id = id;
        this.userId = userId;
        this.nickname = nickname;
        this.content = content;
        this.file = file;
        this.heartCount = heartCount;
    }
}
