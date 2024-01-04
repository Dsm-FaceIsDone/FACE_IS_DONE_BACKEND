package com.example.face_back.domain.post.service;

import com.example.face_back.domain.post.domain.Post;
import com.example.face_back.domain.post.domain.repository.PostRepository;
import com.example.face_back.domain.post.presentation.dto.request.PostRequest;
import com.example.face_back.domain.post.presentation.dto.response.ReturnIdResponse;
import com.example.face_back.domain.post.service.exception.PostNotFoundException;
import com.example.face_back.domain.post.service.exception.UserNotMatchException;
import com.example.face_back.domain.user.service.util.UserUtil;
import com.example.face_back.infra.aws.service.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final S3Util s3Util;
    private final UserUtil userUtil;

    @Transactional
    public ReturnIdResponse create(PostRequest request) {
        Post post = postRepository.save(Post.builder()
                .content(request.getContent())
                .user(userUtil.getUser())
                .build());

        return new ReturnIdResponse(post.getId());
    }

    @Transactional
    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> PostNotFoundException.EXCEPTION);
        if (!post.getUser().getUserId().equals(userUtil.getUserId())) throw UserNotMatchException.EXCEPTION;
        if (post.getPath() != null) s3Util.delete(post.getPath());

        postRepository.delete(post);
    }

    @Transactional
    public void postImage(Long id, MultipartFile file) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);
        if(!post.getUser().getUserId().equals(userUtil.getUserId())) throw UserNotMatchException.EXCEPTION;
        if (post.getPath() != null) s3Util.delete(post.getPath());

        post.updatePath(s3Util.upload(file));
    }
}
