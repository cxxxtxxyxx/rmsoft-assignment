package com.rmsoft.bookmanagement.auth.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenPayload {
    public static final String ID_PAYLOAD = "id";

    private final Long id;
}
