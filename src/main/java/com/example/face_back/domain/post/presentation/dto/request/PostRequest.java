package com.example.face_back.domain.post.presentation.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class PostRequest {
    @NotBlank
    @Size(max = 140)
    private String content;
}
