package com.elibrary.library.repository;

import com.elibrary.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book, String> {
    Boolean existsBooksByIsbn(String isbn);
}
