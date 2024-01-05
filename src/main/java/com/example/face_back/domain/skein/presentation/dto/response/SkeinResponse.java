package com.example.face_back.domain.skein.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SkeinResponse {
    private final Long id;
    private final String userNickname;
    private final String userId;
    private final String file;
    private final String profileImage;

    @Builder
    public SkeinResponse(Long id, String userNickname, String userId, String file, String profileImage){
        this.id = id;
        this.userNickname = userNickname;
        this.userId = userId;
        this.file = file;
        this.profileImage = profileImage;
    }
}
