package com.rmsoft.bookmanagement.auth.exception;

import com.rmsoft.bookmanagement.common.exception.BusinessException;
import com.rmsoft.bookmanagement.common.response.code.ErrorCode;

public class AlreadyEmailExistException extends BusinessException {

    public AlreadyEmailExistException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public AlreadyEmailExistException(ErrorCode errorCode) {
        super(errorCode);
    }
}
