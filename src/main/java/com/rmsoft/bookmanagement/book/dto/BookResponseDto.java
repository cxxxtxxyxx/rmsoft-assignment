package com.rmsoft.bookmanagement.book.dto;

import com.rmsoft.bookmanagement.member.dto.MemberResponseDto;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookResponseDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Trace {

        private MemberResponseDto.Detail member;
        private LocalDateTime borrowedAt;
        private LocalDateTime returnedAt;
    }
}
