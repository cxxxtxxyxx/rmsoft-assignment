package com.rmsoft.bookmanagement.book.repository;

import com.rmsoft.bookmanagement.entity.BookCheckoutRecord;
import com.rmsoft.bookmanagement.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookCheckoutRecordRepository extends JpaRepository<BookCheckoutRecord, Long> {

    @Query("select br" +
            " from BookCheckoutRecord br" +
            " join fetch Book b" +
            " on br.book = b" +
            " where br.book.id = :bookId")
    List<BookCheckoutRecord> findAllByBookId(@Param("bookId") Long bookId);

    Optional<BookCheckoutRecord> findByBookIdAndReturnedAtIsNullAndMember(Long bookId, Member member);
}
