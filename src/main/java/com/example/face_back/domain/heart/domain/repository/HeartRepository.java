package com.example.face_back.domain.heart.domain.repository;

import com.example.face_back.domain.heart.domain.Heart;
import com.example.face_back.domain.post.domain.Post;
import com.example.face_back.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRepository extends JpaRepository<Heart, Long> {
    Boolean existsByUserAndPost(User user, Post post);

    void deleteByUserAndPost(User user, Post post);
}
