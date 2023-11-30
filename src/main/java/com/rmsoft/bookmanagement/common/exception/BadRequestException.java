package com.rmsoft.bookmanagement.common.exception;

import com.rmsoft.bookmanagement.common.response.code.ErrorCode;

public class BadRequestException extends BusinessException {

    public BadRequestException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }
}
