package com.example.face_back.domain.user.service.exception;

import com.example.face_back.global.error.exception.BaseException;
import com.example.face_back.global.error.exception.ErrorCode;

public class AccountIdAlreadyExistException extends BaseException {
    public final BaseException EXCEPTION = new AccountIdAlreadyExistException();

    public AccountIdAlreadyExistException(){
        super(ErrorCode.ACCOUNT_ID_ALREADY_EXIST);
    }
}
