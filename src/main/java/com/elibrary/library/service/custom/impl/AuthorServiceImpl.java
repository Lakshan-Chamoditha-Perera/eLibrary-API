package com.elibrary.library.service.custom.impl;

import com.elibrary.library.entity.Author;
import com.elibrary.library.service.custom.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    @Override
    public Boolean save(Author dto) {
        return null;
    }

    @Override
    public Boolean update(Author dto) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public Author get(String id) {
        return null;
    }

    @Override
    public List<Author> getAll() {
        return null;
    }

    @Override
    public Boolean existsById(String id) {
        return null;
    }
}
