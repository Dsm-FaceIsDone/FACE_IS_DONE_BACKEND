package com.example.face_back.domain.user.service.exception;

import com.example.face_back.global.error.exception.BaseException;
import com.example.face_back.global.error.exception.ErrorCode;

public class PasswordMisMatchException extends BaseException {
    public static final BaseException EXCEPTION = new PasswordMisMatchException();

    public PasswordMisMatchException(){
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
