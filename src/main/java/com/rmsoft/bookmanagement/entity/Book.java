package com.rmsoft.bookmanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
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

    public void update(String name, String publisherName, String authorName, LocalDate publishedAt) {
        this.name = name;
        this.publisherName = publisherName;
        this.authorName = authorName;
        this.publishedAt = publishedAt;
    }
}
