package com.elibrary.library.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorDto implements SuperDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String biography;
    private Integer birthYear;
}
