package com.example.face_back.domain.post.domain;

import com.example.face_back.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(nullable = false, length = 140)
    private String content;

    @NotNull
    private Integer heartCount;

    private String postImgUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Post(String content, Integer heartCount){
        this.content = content;
        this.heartCount = 0;
    }

    public void ImgUpload(String postImgUrl) {
        this.postImgUrl = postImgUrl;
    }

    public void addHeartCount() {
        this.heartCount += 1;
    }

    public void minusHeartCount() {
        this.heartCount -= 1;
    }
}