package com.rmsoft.bookmanagement.auth.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthResponseDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SignIn {

        Long memberId;
        String accessToken;
    }
}
