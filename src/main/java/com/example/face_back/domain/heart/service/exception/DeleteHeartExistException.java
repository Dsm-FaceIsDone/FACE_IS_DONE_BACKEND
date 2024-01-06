package com.example.face_back.domain.heart.service.exception;

import com.example.face_back.global.error.exception.BaseException;
import com.example.face_back.global.error.exception.ErrorCode;

public class DeleteHeartExistException extends BaseException {
    public static final BaseException EXCEPTION= new DeleteHeartExistException();

    public DeleteHeartExistException() {
        super(ErrorCode.DELETE_HEART_EXIST);
    }
}
