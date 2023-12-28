package com.example.face_back.domain.skein.presentation.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class SkeinRequest {
    @NotNull
    private Long id;
}
