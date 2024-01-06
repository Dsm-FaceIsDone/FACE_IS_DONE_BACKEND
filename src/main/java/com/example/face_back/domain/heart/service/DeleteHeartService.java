package com.example.face_back.domain.heart.service;

import com.example.face_back.domain.heart.domain.facade.HeartFacade;
import com.example.face_back.domain.heart.domain.repository.HeartRepository;
import com.example.face_back.domain.heart.presentation.dto.HeartResponse;
import com.example.face_back.domain.heart.service.exception.DeleteHeartExistException;
import com.example.face_back.domain.post.domain.Post;
import com.example.face_back.domain.post.domain.facade.PostFacade;
import com.example.face_back.domain.user.domain.User;
import com.example.face_back.domain.user.domain.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteHeartService {
    private final UserFacade userFacade;
    private final PostFacade postFacade;
    private final HeartFacade heartFacade;
    private final HeartRepository heartRepository;

    @Transactional
    public HeartResponse deleteHeart(Long postId) {
        User user = userFacade.getCurrentUser();
        Post post = postFacade.getPost(postId);

        if (!heartFacade.hasUserGivenHeartToPost(user, post)) {
            throw DeleteHeartExistException.EXCEPTION;
        }

        heartRepository.deleteByUserAndPost(user, post);

        post.minusHeartCount();
        return new HeartResponse(post.getHeartCount());
    }
}
