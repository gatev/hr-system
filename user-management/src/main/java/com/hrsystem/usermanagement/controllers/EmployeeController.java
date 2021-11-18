package com.hrsystem.usermanagement.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.usermanagement.model.Employee;
import com.hrsystem.usermanagement.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable Long employeeId) {
		Optional<Employee> employee = employeeService.findById(employeeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
