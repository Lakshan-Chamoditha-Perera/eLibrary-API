package com.elibrary.library.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto implements SuperDto {
    @NotNull(message = "ISBN cannot be null")
    @Pattern(regexp = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$", message = "ISBN should be in the format of ISBN-10 or ISBN-13")
    private String isbn;

    @NotNull(message = "Title cannot be null")
    private String title;

    @NotNull(message = "Author cannot be null")
    private AuthorDto author;

    @NotNull(message = "Publication year cannot be null")
    private Integer publicationYear;

    @NotNull(message = "Page count cannot be null")
    @Min(value = 1, message = "Page count should be greater than 0")
    private Integer pageCount;

    @NotNull(message = "Genre cannot be null")
    private String genre;

    @NotNull(message = "Publisher cannot be null")
    @Pattern(regexp = "[A-Za-z0-9 .,]+", message = "Publisher should only contain alphabetic characters, numbers, spaces, commas and periods")
    private String publisher;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price should be greater than 0")
    private Double price;

    @NotNull(message = "Availability cannot be null")
    private Boolean available;
}

