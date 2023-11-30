package com.example.face_back.domain.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class RefreshToken {

    @Id
    private String userId;

    @Column(nullable = false)
    private String refreshToken;

    @Builder
    public RefreshToken (String userId, String refreshToken) {
        this.userId = userId;
        this.refreshToken = refreshToken;
    }
}