package com.rmsoft.bookmanagement.book.controller;

import com.rmsoft.bookmanagement.book.code.BookSuccessCode;
import com.rmsoft.bookmanagement.book.dto.BookRequestDto;
import com.rmsoft.bookmanagement.book.dto.BookResponseDto;
import com.rmsoft.bookmanagement.book.service.BookService;
import com.rmsoft.bookmanagement.common.annotation.LoginMemberId;
import com.rmsoft.bookmanagement.common.response.APIDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<?> registerBook(@RequestBody @Valid BookRequestDto.Registration registrationRequestDto) {

        bookService.register(registrationRequestDto);

        return APIDataResponse.empty(BookSuccessCode.REGISTERED);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<?> modifyBook(
            @RequestBody @Valid BookRequestDto.Modification modificationRequestDto,
            @PathVariable("bookId") Long bookId
    ) {
        bookService.modify(modificationRequestDto, bookId);

        return APIDataResponse.empty(BookSuccessCode.MODIFIED);
    }

    @GetMapping("/trace/{bookId}")
    public ResponseEntity<?> findAllTrace(@PathVariable("bookId") Long bookId) {
        List<BookResponseDto.Trace> traces = bookService.searchTraces(bookId);

        return APIDataResponse.of(traces, BookSuccessCode.SUCCESS_TRACE);
    }

    @PostMapping("/checkout/{bookId}")
    public ResponseEntity<?> checkoutBook(
            @PathVariable("bookId") Long bookId,
            @LoginMemberId Long memberId
    ) {
        bookService.checkout(memberId, bookId);

        return APIDataResponse.empty(BookSuccessCode.SUCCESS_CHECKOUT);
    }

    @PostMapping("/returned/{bookId}")
    public ResponseEntity<?> returnBook(
            @PathVariable("bookId") Long bookId,
            @LoginMemberId Long memberId
    ) {
        bookService.returned(memberId, bookId);

        return APIDataResponse.empty(BookSuccessCode.SUCCESS_RETURNED);
    }
}
