package com.rmsoft.bookmanagement.common.exception;

import com.rmsoft.bookmanagement.common.response.code.ErrorCode;

public class NotExistLoginInformationException extends BusinessException {

    public NotExistLoginInformationException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

    public NotExistLoginInformationException(ErrorCode errorCode) {
        super(errorCode);
    }
}
