package com.elibrary.library.dto;

import com.elibrary.library.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto implements SuperDto {
    private String isbn;
    private String title;
    private Author authorDto;
    private Integer publicationYear;
    private Integer pageCount;
    private String genre;
    private String publisher;
    private Double price;
    private Boolean available;
}
