package com.elibrary.library.service.custom.impl;

import com.elibrary.library.dto.BookDto;
import com.elibrary.library.entity.Book;
import com.elibrary.library.repository.BookRepository;
import com.elibrary.library.service.custom.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper mapper;
    @Override
    public Boolean save(BookDto dto)throws RuntimeException {
        if (bookRepository.existsBooksByIsbn(dto.getIsbn())) {
            throw new RuntimeException("Book Already Exist");
        }
        bookRepository.save(mapper.map(dto, Book.class));
        return true;
    }

    @Override
    public Boolean update(BookDto dto) throws RuntimeException{
        if (!bookRepository.existsBooksByIsbn(dto.getIsbn())) {
            throw new RuntimeException("No Book for Update!");
        }
        bookRepository.save(mapper.map(dto, Book.class));
        return true;
    }

    @Override
    public Boolean delete(String id)  throws RuntimeException{
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("No Book for Delete!");
        }
        bookRepository.deleteById(id);
        return true;
    }

    @Override
    public BookDto get(String id)throws RuntimeException  {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("No Book for Delete!");
        }
        return mapper.map(bookRepository.findById(id).get(), BookDto.class);
    }

    @Override
    public List<BookDto> getAll() {
        List<Book> all = bookRepository.findAll();
        return all.stream().map(
                book -> mapper.map(book, BookDto.class)
        ).toList();
    }

    @Override
    public Boolean existsById(String id) {
        return bookRepository.existsById(id);
    }
}
