package com.example.face_back.domain.user.service;

import com.example.face_back.domain.post.domain.repository.PostRepository;
import com.example.face_back.domain.user.domain.User;
import com.example.face_back.domain.user.domain.repository.UserRepository;
import com.example.face_back.domain.user.presentation.dto.response.UserDetailsResponse;
import com.example.face_back.domain.user.service.exception.AccountIdAlreadyExistException;
import com.example.face_back.domain.user.service.util.UserUtil;
import com.example.face_back.infra.aws.service.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserUtil userUtil;
    private final S3Util s3Util;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public UserDetailsResponse getUser() {
        User user = userUtil.getUser();

        return UserDetailsResponse.builder()
                .nickname(user.getNickname())
                .userId(user.getUserId())
                .profileImgUrl(s3Util.getProfileImgUrl(user.getPath()))
                .totalPosts(postRepository.countByUser(user))
                .build();
    }

    public void existsAccountId(String accountId) {
        if(userRepository.existsByUserId(accountId)) throw new AccountIdAlreadyExistException();
    }

}
