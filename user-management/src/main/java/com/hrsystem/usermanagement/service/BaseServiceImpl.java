package com.hrsystem.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hrsystem.usermanagement.model.BaseEntity;
import com.hrsystem.usermanagement.repository.BaseRepository;

import java.util.Optional;

public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    @Autowired
    private BaseRepository<T> baseRepository;

    @Override
    public T save(T t) {
        return baseRepository.save(t);
    }

    @Override
    public void delete(T t) {
        baseRepository.delete(t);
    }

    @Override
    public Optional<T> findById(Long id) {
        return baseRepository.findById(id);
    }

    @Override
    public Iterable<T> findAll() {
        return baseRepository.findAll();
    }
}
