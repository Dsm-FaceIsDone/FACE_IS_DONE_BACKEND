package com.example.face_back.infra.aws.exception;

import com.example.face_back.global.error.exception.BaseException;
import com.example.face_back.global.error.exception.ErrorCode;

public class ImageUploadFailException extends BaseException {
    public static final BaseException EXCEPTION = new ImageUploadFailException();

    private ImageUploadFailException(){
        super(ErrorCode.IMAGE_UPLOAD_FAIL);
    }
}
