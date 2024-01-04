package com.example.face_back.domain.post.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ReturnIdResponse {
    private Long id;

    @Builder
    public ReturnIdResponse (Long id) {
        this.id = id;
    }
}