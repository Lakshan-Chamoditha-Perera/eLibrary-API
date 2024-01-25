package com.elibrary.library.service.custom.impl;

import com.elibrary.library.dto.AuthorDto;
import com.elibrary.library.entity.Author;
import com.elibrary.library.repository.AuthorRepository;
import com.elibrary.library.service.custom.AuthorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final ModelMapper mapper;

    @Override
    public Boolean save(AuthorDto dto) throws RuntimeException {
        if (authorRepository.existsById(dto.getId())) {
            throw new RuntimeException("Author Already Exist");
        }
        authorRepository.save(mapper.map(dto, Author.class));
        return true;
    }

    @Override
    public Boolean update(AuthorDto dto) {
        if (!authorRepository.existsById(dto.getId())) {
            throw new RuntimeException("No Author for Update!");
        }
        authorRepository.save(mapper.map(dto, Author.class));
        return true;
    }

    @Override
    public Boolean delete(String id) {
        if (!authorRepository.existsById(id)) {
            throw new RuntimeException("No Author for Delete!");
        }
        authorRepository.deleteById(id);
        return true;
    }

    @Override
    public AuthorDto get(String id) {
        if (!authorRepository.existsById(id)) {
            throw new RuntimeException("No Author for Delete!");
        }
        return mapper.map(authorRepository.findById(id).get(), AuthorDto.class);
    }

    @Override
    public List<AuthorDto> getAll() {
        List<Author> all = authorRepository.findAll();
        return all.stream().map(
                author -> mapper.map(author, AuthorDto.class)
        ).toList();
    }

    @Override
    public Boolean existsById(String id) {
        return authorRepository.existsById(id);
    }
}
