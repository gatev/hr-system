package com.hrsystem.usermanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.hrsystem.usermanagement.model.Employee;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee> {
//    Optional<Employee> findByUsername(String username);
//    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    Optional<Employee> findByEmail(String email);
//    Optional<Employee> findByUsernameOrEmail(String username, String email);
//    List<Employee> findByIdIn(List<Long> userIds);
}
