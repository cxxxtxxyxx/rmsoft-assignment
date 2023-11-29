package com.rmsoft.bookmanagement.member.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberResponseDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Detail {

        private Long id;
        private String name;
    }
}
