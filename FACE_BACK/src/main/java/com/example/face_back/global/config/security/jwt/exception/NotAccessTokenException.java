package com.example.face_back.global.config.security.jwt.exception;

import com.example.face_back.global.error.exception.BaseException;
import com.example.face_back.global.error.exception.ErrorCode;

public class NotAccessTokenException extends BaseException {
    public static final BaseException EXCEPTION = new NotAccessTokenException();

    public NotAccessTokenException(){
        super(ErrorCode.NOT_ACCESS_TOKEN);
    }
}
