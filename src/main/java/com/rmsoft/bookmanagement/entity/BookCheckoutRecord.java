package com.rmsoft.bookmanagement.entity;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(
        name = "checkout_record",
        uniqueConstraints =
        @UniqueConstraint(
                name = "MEMBER_BOOK_UNIQUE_IDX",
                columnNames = {"member_id", "book_id"}
        )
)
public class BookCheckoutRecord extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Book book;

    @Column(nullable = false)
    private LocalDateTime borrowedAt;

    @Column
    private LocalDateTime returnedAt;

    public static BookCheckoutRecord of(Member member, Book book, LocalDateTime borrowedAt) {
        return BookCheckoutRecord.builder()
                .book(book)
                .borrowedAt(borrowedAt)
                .member(member)
                .build();
    }

    public void returnedBook(LocalDateTime returnedAt) {
        this.returnedAt = returnedAt;
    }
}
