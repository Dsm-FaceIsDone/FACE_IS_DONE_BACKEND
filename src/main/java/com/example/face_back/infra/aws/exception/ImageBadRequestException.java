package com.example.face_back.infra.aws.exception;

import com.example.face_back.global.error.exception.BaseException;
import com.example.face_back.global.error.exception.ErrorCode;

public class ImageBadRequestException extends BaseException {
    public static final BaseException EXCEPTION = new ImageBadRequestException();

    private ImageBadRequestException(){
        super(ErrorCode.IMAGE_BAD_REQUEST);
    }
}
