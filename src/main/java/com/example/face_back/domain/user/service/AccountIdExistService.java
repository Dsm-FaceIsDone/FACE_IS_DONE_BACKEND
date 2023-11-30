package com.example.face_back.domain.user.service;

import com.example.face_back.domain.user.domain.repository.UserRepository;
import com.example.face_back.domain.user.service.exception.AccountIdAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class AccountIdExistService {
    private final UserRepository userRepository;

    public void exist(String userId) {
        if (userRepository.existsByUserId(userId)) throw new AccountIdAlreadyExistException();
    }
}