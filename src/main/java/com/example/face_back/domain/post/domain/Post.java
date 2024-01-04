package com.example.face_back.domain.post.domain;

import com.example.face_back.domain.skein.domain.Skein;
import com.example.face_back.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

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

    private String path;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Skein> skeins = new ArrayList<>();

    @Builder
    public Post(User user, String content, Integer heartCount){
        this.user = user;
        this.content = content;
        this.heartCount = 0;
    }

    public void addHeartCount() {
        this.heartCount += 1;
    }

    public void minusHeartCount() {
        this.heartCount -= 1;
    }

    public String updatePath(String path) {
        this.path = path;
        return this.path;
    }
}