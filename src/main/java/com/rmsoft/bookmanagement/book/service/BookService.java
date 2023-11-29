package com.rmsoft.bookmanagement.book.service;

import com.rmsoft.bookmanagement.book.dto.BookRequestDto;
import com.rmsoft.bookmanagement.book.repository.BookRepository;
import com.rmsoft.bookmanagement.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public void register(BookRequestDto.registration registrationRequestDto) {

        Book book = Book.builder()
                .authorName(registrationRequestDto.getAuthorName())
                .name(registrationRequestDto.getName())
                .publishedAt(registrationRequestDto.getPublishedAt())
                .publisherName(registrationRequestDto.getPublisherName())
                .build();

        bookRepository.save(book);
    }
}
