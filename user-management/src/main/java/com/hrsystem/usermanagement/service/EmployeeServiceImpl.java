package com.hrsystem.usermanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hrsystem.usermanagement.model.Employee;
import com.hrsystem.usermanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService {
	
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Boolean existsByEmail(String email) {
        return employeeRepository.existsByEmail(email);
    }

    @Override
    public Optional<Employee> findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public List<Employee> findByIdIn(List<Long> userIds) {
        return employeeRepository.findByIdIn(userIds);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee> employee = employeeRepository.findByEmail(username);
		if (!employee.isPresent()) {
			throw new UsernameNotFoundException("Employee with email: " + username + " not found");
		}
		return new User(employee.get().getEmail(), employee.get().getPassword(), true, true, true, true, new ArrayList<>());
	}
}
