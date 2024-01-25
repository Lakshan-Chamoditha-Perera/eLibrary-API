package com.elibrary.library.service;

import com.elibrary.library.dto.SuperDto;

import java.util.List;

public interface SuperService<T extends SuperDto> {
    Boolean save(T dto);

    Boolean update(T dto);

    Boolean delete(String id);

    T get(String id);

    List<T> getAll();

    Boolean existsById(String id);

}
