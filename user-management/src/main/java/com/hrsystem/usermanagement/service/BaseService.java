package com.hrsystem.usermanagement.service;

import com.hrsystem.usermanagement.exceptions.ServiceApiException;
import com.hrsystem.usermanagement.model.BaseEntity;

import java.util.Optional;

public interface BaseService<T extends BaseEntity> {
    T save(T t) throws ServiceApiException;
    void delete(T t) throws ServiceApiException;
    Optional<T> findById(Long id) throws ServiceApiException;
    Iterable<T> findAll() throws ServiceApiException;
}
