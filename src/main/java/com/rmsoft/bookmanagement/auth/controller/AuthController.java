package com.rmsoft.bookmanagement.auth.controller;

import com.rmsoft.bookmanagement.auth.code.AuthSuccessCode;
import com.rmsoft.bookmanagement.auth.dto.AuthRequestDto;
import com.rmsoft.bookmanagement.auth.dto.AuthResponseDto;
import com.rmsoft.bookmanagement.auth.service.AuthService;
import com.rmsoft.bookmanagement.common.response.APIDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody @Valid AuthRequestDto.SignUp signUpRequestDto) {
        authService.create(signUpRequestDto);

        return APIDataResponse.empty(AuthSuccessCode.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody @Valid AuthRequestDto.SignIn signInRequestDto) {
        AuthResponseDto.SignIn signInResponseDto = authService.signIn(signInRequestDto);

        return APIDataResponse.of(signInResponseDto, AuthSuccessCode.LOGIN);
    }
}
