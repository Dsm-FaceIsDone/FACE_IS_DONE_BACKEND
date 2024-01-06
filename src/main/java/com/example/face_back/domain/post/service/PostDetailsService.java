package com.example.face_back.domain.post.service;

import com.example.face_back.domain.post.domain.Post;
import com.example.face_back.domain.post.domain.repository.PostRepository;
import com.example.face_back.domain.post.presentation.dto.response.PostResponse;
import com.example.face_back.domain.post.service.exception.PostNotFoundException;
import com.example.face_back.domain.skein.presentation.dto.response.SkeinResponse;
import com.example.face_back.infra.aws.service.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PostDetailsService {
    private final PostRepository postRepository;
    private final S3Util s3Util;

    @Transactional(readOnly = true)
    public PostResponse getPostDetails(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> PostNotFoundException.EXCEPTION);

        return PostResponse.builder()
                .id(post.getId())
                .userId(post.getUser().getUserId())
                .nickname(post.getUser().getNickname())
                .profileImage(s3Util.getProfileImgUrl(post.getUser().getPath()))
                .content(post.getContent())
                .file(s3Util.getPostImgUrl(post.getPath()))
                .heartCount(post.getHeartCount())
                .skeins(post.getSkeins().stream().map(skein -> {
                    return SkeinResponse.builder()
                            .id(skein.getId())
                            .userNickname(skein.getUser().getNickname())
                            .profileImage(s3Util.getProfileImgUrl(skein.getUser().getPath()))
                            .build();
                    }
                ).collect(Collectors.toList()))
                .build();
    }
}
