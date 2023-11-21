package com.example.face_back.global.config.security.jwt.exception;

import com.example.face_back.global.error.exception.BaseException;
import com.example.face_back.global.error.exception.ErrorCode;

public class TokenUnauthorizedException extends BaseException {
    public static final BaseException EXCEPTION = new TokenUnauthorizedException();

    public TokenUnauthorizedException(){
        super(ErrorCode.TOKEN_UNAUTHORIZED);
    }
}
