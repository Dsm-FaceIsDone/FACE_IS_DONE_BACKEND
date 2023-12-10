package com.example.face_back.domain.user.service.exception;

import com.example.face_back.global.error.exception.BaseException;
import com.example.face_back.global.error.exception.ErrorCode;

public class RefreshTokenNotFound extends BaseException {
    public static final BaseException EXCEPTION = new RefreshTokenNotFound();

    private RefreshTokenNotFound(){
        super(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }
}
