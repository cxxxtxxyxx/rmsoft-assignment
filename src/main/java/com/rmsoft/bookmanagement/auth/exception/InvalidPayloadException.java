package com.rmsoft.bookmanagement.auth.exception;

import com.rmsoft.bookmanagement.common.exception.BusinessException;
import com.rmsoft.bookmanagement.common.response.code.ErrorCode;

public class InvalidPayloadException extends BusinessException {

    public InvalidPayloadException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public InvalidPayloadException(ErrorCode errorCode) {
        super(errorCode);
    }
}
