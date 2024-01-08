package com.example.face_back.domain.skein.service;

import com.example.face_back.domain.post.domain.Post;
import com.example.face_back.domain.post.domain.repository.PostRepository;
import com.example.face_back.domain.post.presentation.dto.response.ReturnIdResponse;
import com.example.face_back.domain.post.service.exception.PostNotFoundException;
import com.example.face_back.domain.post.service.exception.UserNotMatchException;
import com.example.face_back.domain.skein.domain.Skein;
import com.example.face_back.domain.skein.domain.repository.SkeinRepository;
import com.example.face_back.domain.skein.presentation.dto.request.SkeinRequest;
import com.example.face_back.domain.skein.service.exception.SkeinNotFoundException;
import com.example.face_back.domain.user.domain.User;
import com.example.face_back.domain.user.service.util.UserUtil;
import com.example.face_back.infra.aws.service.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Service
public class SkeinService {
    private final SkeinRepository skeinRepository;
    private final PostRepository postRepository;
    private final UserUtil userUtil;
    private final S3Util s3Util;

    @Transactional
    public ReturnIdResponse creat(SkeinRequest request) {
        Post post = postRepository.findById(request.getId())
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        Skein skein = skeinRepository.save(Skein.builder()
                .post(post)
                .user(userUtil.getUser())
                .build());

        return new ReturnIdResponse(skein.getId());
    }

    @Transactional
    public void skeinImage(Long id, MultipartFile file) {
        Skein skein = skeinRepository.findById(id)
                .orElseThrow(()-> SkeinNotFoundException.EXCEPTION);
        if (!skein.getUser().getUserId().equals(userUtil.getUserId())) throw UserNotMatchException.EXCEPTION;
        if (skein.getPath() != null) s3Util.delete(skein.getPath());

        skein.updatePath(s3Util.upload(file));
    }

    @Transactional
    public void delete(Long id) {
        Skein skein = skeinRepository.findById(id)
                .orElseThrow(() -> SkeinNotFoundException.EXCEPTION);
        if(!skein.getUser().getUserId().equals(userUtil.getUserId())) throw UserNotMatchException.EXCEPTION;

        skeinRepository.delete(skein);
    }
}
