package com.elibrary.library.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto implements SuperDto {
    @NotNull(message = "Author ID cannot be null")
    @Pattern(regexp = "A\\d{3}", message = "Author ID should start with A and have 3 digits")
    private String id;
    @NotNull(message = "First name cannot be null")
    @Pattern(regexp = "[A-Za-z ]+", message = "First name should only contain alphabetic characters and spaces")
    private String firstName;
    @NotNull(message = "Last name cannot be null")
    @Pattern(regexp = "[A-Za-z ]+", message = "Last name should only contain alphabetic characters and spaces")
    private String lastName;
    @NotNull(message = "Email cannot be null")
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}", message = "Email should be in the format of <username>@<domain>.<extension>")
    private String email;
    @NotNull(message = "Biography cannot be null")
    @Pattern(regexp = "[A-Za-z0-9 .,]+", message = "Biography should only contain alphabetic characters, numbers, spaces, commas and periods")
    private String biography;
    @NotNull(message = "Date of birth cannot be null")
    private Date dateOfBirth;
}
