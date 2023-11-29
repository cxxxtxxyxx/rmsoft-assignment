package com.rmsoft.bookmanagement.book.code;

import com.rmsoft.bookmanagement.common.response.code.SuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookSuccessCode implements SuccessCode {

    REGISTERED(201, "MS001", "도서 등록에 성공하였습니다");

    private final int status;
    private final String code;
    private final String message;
}
