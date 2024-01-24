package com.elibrary.library.service.custom.impl;

import com.elibrary.library.entity.Book;
import com.elibrary.library.service.custom.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Override
    public Boolean save(Book dto) {
        return null;
    }

    @Override
    public Boolean update(Book dto) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public Book get(String id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public Boolean existsById(String id) {
        return null;
    }
}
