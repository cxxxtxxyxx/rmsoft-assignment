package com.rmsoft.bookmanagement.auth.dto;

import lombok.*;

import javax.validation.constraints.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthRequestDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SignUp {

        @Email
        @NotNull
        @NotEmpty
        private String email;

        @NotNull
        @NotEmpty
        @Size(min = 1, max = 20)
        private String name;

        @NotNull
        @NotEmpty
        @Size(min = 8, max = 16)
        private String password;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SignIn {

        @Email
        @NotNull
        @NotEmpty
        private String email;

        @NotNull
        @NotEmpty
        @Size(min = 8, max = 16)
        private String password;
    }
}
