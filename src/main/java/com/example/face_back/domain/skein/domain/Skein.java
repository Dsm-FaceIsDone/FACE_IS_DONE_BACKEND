package com.example.face_back.domain.skein.domain;

import com.example.face_back.domain.post.domain.Post;
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

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Skein {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skein_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private String path;
    @Builder
    public Skein(User user, Post post, String path){
        this.user = user;
        this.post = post;
        this.path = path;
    }

    public String updatePath(String path) {
        this.path = path;
        return this.path;
    }
}
