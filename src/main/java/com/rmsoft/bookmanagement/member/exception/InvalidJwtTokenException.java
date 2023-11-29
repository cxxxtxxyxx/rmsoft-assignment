package com.rmsoft.bookmanagement.member.exception;

import com.rmsoft.bookmanagement.common.exception.BusinessException;
import com.rmsoft.bookmanagement.common.response.code.ErrorCode;

public class InvalidJwtTokenException extends BusinessException {

    public InvalidJwtTokenException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public InvalidJwtTokenException(ErrorCode errorCode) {
        super(errorCode);
    }
}
