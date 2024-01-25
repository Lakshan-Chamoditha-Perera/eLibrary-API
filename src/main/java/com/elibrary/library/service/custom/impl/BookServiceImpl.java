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
    public Boolean save(BookDto dto) {
        if (bookRepository.existsById(dto.getCode())) {
            throw new RuntimeException("Book Already Exist");
        }
        bookRepository.save(mapper.map(dto, Book.class));
        return true;
    }

    @Override
    public Boolean update(BookDto dto) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public BookDto get(String id) {
        return null;
    }

    @Override
    public List<BookDto> getAll() {
        return null;
    }

    @Override
    public Boolean existsById(String id) {
        return null;
    }
}
