package com.hrsystem.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrsystem.usermanagement.model.BaseEntity;

public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
