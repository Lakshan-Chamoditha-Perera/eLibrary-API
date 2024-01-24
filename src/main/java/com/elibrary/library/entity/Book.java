package com.elibrary.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    @Id
    private String isbn;
    private String title;
    @ManyToOne
    private Author author;
    private Integer publicationYear;
    private Integer pageCount;
    private String genre;
    private String publisher;
    private Double price;
    private Boolean available;
}
