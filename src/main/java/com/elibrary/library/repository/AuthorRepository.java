package com.elibrary.library.repository;

import com.elibrary.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AuthorRepository extends JpaRepository<Author, String> {
    Boolean existsAuthorById(String id);
}
