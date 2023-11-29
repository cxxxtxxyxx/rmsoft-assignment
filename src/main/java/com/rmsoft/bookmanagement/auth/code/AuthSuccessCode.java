package com.rmsoft.bookmanagement.auth.code;

import com.rmsoft.bookmanagement.common.response.code.SuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuthSuccessCode implements SuccessCode {
    CREATED(201, "MS001", "유저 생성에 성공하였습니다"),
    LOGIN(200, "MS002", "로그인에 성공하였습니다");

    private final int status;
    private final String code;
    private final String message;
}
