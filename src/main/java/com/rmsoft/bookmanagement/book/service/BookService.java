package com.rmsoft.bookmanagement.book.service;

import com.rmsoft.bookmanagement.book.code.BookErrorCode;
import com.rmsoft.bookmanagement.book.dto.BookRequestDto;
import com.rmsoft.bookmanagement.book.dto.BookResponseDto;
import com.rmsoft.bookmanagement.book.repository.BookCheckoutRecordRepository;
import com.rmsoft.bookmanagement.book.repository.BookRepository;
import com.rmsoft.bookmanagement.common.exception.NotFoundException;
import com.rmsoft.bookmanagement.entity.Book;
import com.rmsoft.bookmanagement.entity.BookCheckoutRecord;
import com.rmsoft.bookmanagement.member.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookCheckoutRecordRepository bookCheckoutRecordRepository;

    @Transactional
    public void register(BookRequestDto.Registration registrationRequestDto) {

        Book book = Book.builder()
                .authorName(registrationRequestDto.getAuthorName())
                .name(registrationRequestDto.getName())
                .publishedAt(registrationRequestDto.getPublishedAt())
                .publisherName(registrationRequestDto.getPublisherName())
                .build();

        bookRepository.save(book);
    }

    public List<BookResponseDto.Trace> searchTraces(Long bookId) {

        List<BookCheckoutRecord> records = bookCheckoutRecordRepository.findAllByBookId(bookId);

        return records.stream()
                .map(record -> {
                    MemberResponseDto.Detail detail = MemberResponseDto.Detail.builder()
                            .id(record.getMember().getId())
                            .name(record.getMember().getName())
                            .build();
                    return BookResponseDto.Trace.builder()
                            .member(detail)
                            .borrowedAt(record.getBorrowedAt())
                            .returnedAt(record.getReturnedAt())
                            .build();
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public void modify(BookRequestDto.Modification modificationRequestDto, Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException(BookErrorCode.NOT_FOUND));

        book.update(
                modificationRequestDto.getName(),
                modificationRequestDto.getPublisherName(),
                modificationRequestDto.getAuthorName(),
                modificationRequestDto.getPublishedAt()
        );
    }
}
