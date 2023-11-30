package com.rmsoft.bookmanagement.book.repository;

import com.rmsoft.bookmanagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsById(Long bookId);
}
