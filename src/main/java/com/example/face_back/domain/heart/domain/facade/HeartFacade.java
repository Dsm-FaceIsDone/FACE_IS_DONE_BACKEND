package com.example.face_back.domain.heart.domain.facade;

import com.example.face_back.domain.heart.domain.repository.HeartRepository;
import com.example.face_back.domain.post.domain.Post;
import com.example.face_back.domain.post.domain.repository.PostRepository;
import com.example.face_back.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HeartFacade {
    private final HeartRepository heartRepository;

    public boolean hasUserGivenHeartToPost(User user, Post post) {
        return heartRepository.existsByUserAndPost(user, post);
    }
}