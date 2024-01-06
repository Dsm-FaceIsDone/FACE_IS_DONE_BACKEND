package com.example.face_back.domain.heart.service.exception;

import com.example.face_back.global.error.exception.BaseException;
import com.example.face_back.global.error.exception.ErrorCode;

public class HeartExistException extends BaseException {
    public static final BaseException EXCEPTION = new HeartExistException();

    private HeartExistException() {
        super(ErrorCode.HEART_EXIST);
    }
}
