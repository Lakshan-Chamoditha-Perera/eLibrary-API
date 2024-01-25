package com.elibrary.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String biography;
    private Date dateOfBirth;
    @OneToMany(mappedBy = "author")
    @ToString.Exclude
    private List<Book> writtenBooks = new ArrayList<>();
}
