package com.rmsoft.bookmanagement.auth.exception;

import com.rmsoft.bookmanagement.common.exception.BusinessException;
import com.rmsoft.bookmanagement.common.response.code.ErrorCode;

public class NotFoundMemberException extends BusinessException {

    public NotFoundMemberException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public NotFoundMemberException(ErrorCode errorCode) {
        super(errorCode);
    }
}
