package com.example.face_back.domain.skein.service.exception;

import com.example.face_back.global.error.exception.BaseException;
import com.example.face_back.global.error.exception.ErrorCode;

public class SkeinNotFoundException extends BaseException {
    public static final BaseException EXCEPTION = new SkeinNotFoundException();

    public SkeinNotFoundException(){
        super(ErrorCode.SKEIN_NOT_FOUND);
    }
}
