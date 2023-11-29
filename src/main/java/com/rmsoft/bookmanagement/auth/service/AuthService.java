package com.rmsoft.bookmanagement.auth.service;

import com.rmsoft.bookmanagement.auth.code.AuthErrorCode;
import com.rmsoft.bookmanagement.auth.domain.TokenManager;
import com.rmsoft.bookmanagement.auth.domain.TokenPayload;
import com.rmsoft.bookmanagement.auth.dto.AuthRequestDto;
import com.rmsoft.bookmanagement.auth.dto.AuthResponseDto;
import com.rmsoft.bookmanagement.auth.exception.AlreadyEmailExistException;
import com.rmsoft.bookmanagement.auth.exception.InvalidPayloadException;
import com.rmsoft.bookmanagement.auth.exception.NotFoundMemberException;
import com.rmsoft.bookmanagement.entity.Member;
import com.rmsoft.bookmanagement.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenManager tokenManager;

    @Transactional
    public void create(AuthRequestDto.SignUp signUpRequestDto) {

        Member member = getMemberByEmailOrNull(signUpRequestDto.getEmail());

        validateAlreadyExistMember(member);

        Member signUpMember = createMember(signUpRequestDto);
        memberRepository.save(signUpMember);
    }

    public AuthResponseDto.SignIn signIn(AuthRequestDto.SignIn signInRequestDto) {

        Long memberId = validateSignInPayload(signInRequestDto);
        String accessToken = tokenManager.generateAccessToken(new TokenPayload(memberId));

        return AuthResponseDto.SignIn.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .build();
    }

    private Long validateSignInPayload(AuthRequestDto.SignIn signInRequestDto) {
        Member member = getMemberByEmailOrThrow(signInRequestDto);

        validatePassword(signInRequestDto.getPassword(), member.getPassword());

        return member.getId();
    }

    private void validatePassword(String payloadPassword, String encodedPassword) {
        if (!passwordEncoder.matches(payloadPassword, encodedPassword)) {
            throw new InvalidPayloadException(AuthErrorCode.INVALID_PAYLOAD);
        }
    }

    private Member getMemberByEmailOrThrow(AuthRequestDto.SignIn signInRequestDto) {
        return memberRepository.findByEmail(signInRequestDto.getEmail())
                .orElseThrow(() -> new NotFoundMemberException(AuthErrorCode.NOT_FOUND_MEMBER_BY_EMAIL));
    }


    private Member getMemberByEmailOrNull(String email) {
        return memberRepository.findByEmail(email)
                .orElse(null);
    }

    private Member createMember(AuthRequestDto.SignUp signUpRequestDto) {
        String encodedPassword = getEncodedPassword(signUpRequestDto.getPassword());

        return Member.builder()
                .email(signUpRequestDto.getEmail())
                .name(signUpRequestDto.getName())
                .password(encodedPassword)
                .build();
    }

    private String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    private void validateAlreadyExistMember(Member member) {
        if (member != null) {
            throw new AlreadyEmailExistException(AuthErrorCode.ALREADY_EXIST_EMAIL);
        }
    }
}
