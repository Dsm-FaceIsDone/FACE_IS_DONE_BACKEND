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
public class User {
    @Id
    @Column(nullable = false, length = 16, unique = true)
    private String userId;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(nullable = false, length = 10)
    private String nickname;

    private String path;

    @Builder
    public User(String userId, String password, String nickname, String path){
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.path = "";
    }

    public String updatePath(String path) {
        this.path = path;
        return this.path;
    }
}