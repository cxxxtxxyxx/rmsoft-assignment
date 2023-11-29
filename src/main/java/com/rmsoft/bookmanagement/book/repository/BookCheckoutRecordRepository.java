package com.rmsoft.bookmanagement.book.repository;

import com.rmsoft.bookmanagement.entity.BookCheckoutRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookCheckoutRecordRepository extends JpaRepository<BookCheckoutRecord, Long> {

    @Query("select br" +
            " from BookCheckoutRecord br" +
            " join fetch Book b" +
            " on br.book = b" +
            " where br.book.id = :bookId")
    List<BookCheckoutRecord> findAllByBookId(@Param("bookId") Long bookId);
}
