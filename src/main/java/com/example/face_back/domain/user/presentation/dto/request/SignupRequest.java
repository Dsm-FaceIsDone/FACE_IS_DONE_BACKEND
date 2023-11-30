package com.example.face_back.domain.user.presentation.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class SignupRequest {
    @NotBlank
    @Size(min = 5, max = 16)
    private String accountId;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    @NotBlank
    @Size(min = 2, max = 10)
    private String nickname;
}
