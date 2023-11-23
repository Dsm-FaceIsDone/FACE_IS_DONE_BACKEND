package com.example.face_back.domain.user.service.exception;

import com.example.face_back.global.error.exception.BaseException;
import com.example.face_back.global.error.exception.ErrorCode;

public class UserNotFoundException extends BaseException {
    public static final BaseException EXCEPTION= new UserNotFoundException();

    public UserNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}
