package com.hrsystem.usermanagement.service;


import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.hrsystem.usermanagement.model.Employee;

public interface EmployeeService extends BaseService<Employee>, UserDetailsService{
    Boolean existsByEmail(String email);
    Optional<Employee> findByEmail(String email);
    List<Employee> findByIdIn(List<Long> userIds);

}
