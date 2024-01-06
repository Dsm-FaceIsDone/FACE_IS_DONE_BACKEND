package com.example.face_back.domain.post.service;

import com.example.face_back.domain.post.domain.Post;
import com.example.face_back.domain.post.domain.repository.PostRepository;
import com.example.face_back.domain.post.presentation.dto.response.PostListResponse;
import com.example.face_back.domain.user.service.util.UserUtil;
import com.example.face_back.infra.aws.service.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostListService {
    private final PostRepository postRepository;
    private final UserUtil userUtil;
    private final S3Util s3Util;

    public PostListResponse getUserPostsPaged(Pageable pageable) {
        Page<Post> posts = postRepository.findAllByUserOrderByIdDesc(userUtil.getUser(), pageable);

        return new PostListResponse(posts.stream().map(this::ofPostResponse).collect(Collectors.toList()));
    }

    public PostListResponse findPost(String title, Pageable page) {
        Page<Post> posts;

        posts = postRepository.findAllByContentContainingOrderByIdDesc(title, page);;


        return new PostListResponse(posts.stream().map(this::ofPostResponse).collect(Collectors.toList()));
    }

    private PostListResponse.PostResponse ofPostResponse(Post post) {
        return PostListResponse.PostResponse.builder()
                .id(post.getId())
                .userId(post.getUser().getUserId())
                .content(post.getContent())
                .nickname(post.getUser().getNickname())
                .profileImage(s3Util.getProfileImgUrl(post.getUser().getPath()))
                .heartCount(post.getHeartCount())
                .build();
    }
}
