package com.rmsoft.bookmanagement.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "checkout_record",
        uniqueConstraints =
        @UniqueConstraint(
                name = "MEMBER_BOOK_UNIQUE_IDX",
                columnNames = {"member_id", "book_id"}
        )
)
public class CheckoutRecord extends BaseTimeEntity {

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
}
