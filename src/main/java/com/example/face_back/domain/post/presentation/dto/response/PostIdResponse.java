package com.example.face_back.domain.post.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostIdResponse {
    private Long id;

    @Builder
    public PostIdResponse (Long id) {
        this.id = id;
    }
}