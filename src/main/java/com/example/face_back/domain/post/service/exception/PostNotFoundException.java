package com.example.face_back.domain.post.service.exception;

import com.example.face_back.global.error.exception.BaseException;
import com.example.face_back.global.error.exception.ErrorCode;

public class PostNotFoundException extends BaseException {
    public static final BaseException EXCEPTION = new PostNotFoundException();

    public PostNotFoundException(){
        super(ErrorCode.POST_NOT_FOUND);
    }
}
