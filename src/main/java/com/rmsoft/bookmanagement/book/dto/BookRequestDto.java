package com.rmsoft.bookmanagement.book.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookRequestDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class registration {

        @NotNull
        @NotEmpty
        private String name;

        @NotNull
        @NotEmpty
        private String publisherName;

        @NotNull
        @NotEmpty
        private String authorName;

        @NotNull
        private LocalDate publishedAt;
    }
}
