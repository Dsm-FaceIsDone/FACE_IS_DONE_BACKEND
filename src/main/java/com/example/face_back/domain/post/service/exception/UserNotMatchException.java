package com.example.face_back.domain.post.service.exception;

import com.example.face_back.domain.user.service.exception.UserNotFoundException;
import com.example.face_back.global.error.exception.BaseException;
import com.example.face_back.global.error.exception.ErrorCode;

public class UserNotMatchException extends BaseException {
    public static final BaseException EXCEPTION = new UserNotMatchException();

    public UserNotMatchException(){
        super(ErrorCode.USER_NOT_MATCH);
    }
}
