package com.example.face_back.domain.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {
    @Id
    @Column(name = "user_id", nullable = false, length = 16)
    private String userId;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 10)
    private String nickname;

    private String profileImageUrl;

    @Builder
    public User(String userId, String password, String nickname){
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
    }

    public void profileImgUpload(String profileImageUrl){
        this.profileImageUrl = profileImageUrl;
    }
}