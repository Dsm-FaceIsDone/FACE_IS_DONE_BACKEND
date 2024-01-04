package com.example.face_back.domain.post.presentation.dto.response;

import com.example.face_back.domain.skein.presentation.dto.response.SkeinResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class PostResponse {
    private final Long id;
    private final String userId;
    private final String nickname;
    private final String content;
    private final String profileImage;
    private final String file;
    private final List<SkeinResponse> skeins;
    private final Integer heartCount;

    @Builder
    private PostResponse(Long id, String userId, String nickname, String content, String file, List<SkeinResponse> skeins, Integer heartCount, String profileImage){
        this.id = id;
        this.userId = userId;
        this.nickname = nickname;
        this.content = content;
        this.profileImage = profileImage;
        this.file = file;
        this.skeins = skeins;
        this.heartCount = heartCount;
    }
}
