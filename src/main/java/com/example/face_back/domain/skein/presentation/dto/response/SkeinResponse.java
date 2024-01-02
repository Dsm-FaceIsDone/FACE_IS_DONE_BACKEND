package com.example.face_back.domain.skein.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SkeinResponse {
    private final Long id;
    private final String userNickname;
    private final String userId;

    @Builder
    public SkeinResponse(Long id, String userNickname, String userId){
        this.id = id;
        this.userNickname = userNickname;
        this.userId = userId;
    }
}
