package com.rmsoft.bookmanagement.common.exception;

import com.rmsoft.bookmanagement.common.response.code.ErrorCode;

public class NotFoundException extends BusinessException {

    public NotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
