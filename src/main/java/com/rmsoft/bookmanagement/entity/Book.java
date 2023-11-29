package com.rmsoft.bookmanagement.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Book extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String publisherName;

    @Column(nullable = false)
    private String authorName;

    @Column(nullable = false)
    private LocalDate publishedAt;
}
