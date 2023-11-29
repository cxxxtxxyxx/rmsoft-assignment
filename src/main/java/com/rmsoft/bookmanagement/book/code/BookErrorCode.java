package com.rmsoft.bookmanagement.book.code;

import com.rmsoft.bookmanagement.common.response.code.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookErrorCode implements ErrorCode {

    NOT_FOUND(400, "BS001", "존재하지 않는 도서입니다.");

    private final int status;
    private final String code;
    private final String message;
}
