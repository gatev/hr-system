package com.hrsystem.holidaymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrsystem.holidaymanagement.model.Holiday;
import com.hrsystem.holidaymanagement.model.HolidayRequest;
import com.hrsystem.holidaymanagement.service.HolidayService;

@RestController
@RequestMapping("/api/holidays")
public class HolidayController {

	@Autowired
	private HolidayService holidayService;
	
	
	@PostMapping("/ask")
	public ResponseEntity<String> saveHoliday(@RequestBody HolidayRequest holidayRequest) {
		Holiday holiday = holidayService.save(holidayRequest);
		return new ResponseEntity<String>("Holiday with id " + holiday.getId() + " has been added", HttpStatus.OK);
	}
	
	@GetMapping("/get/{employeeId}")
    public ResponseEntity<List<Holiday>> getAllByEmployeeId(@PathVariable Long employeeId) {
        List<Holiday> result = holidayService.findByEmployeeId(employeeId);
        return ResponseEntity.ok(result);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/all")
    public ResponseEntity<List<Holiday>> getAll() {
        List<Holiday> result = holidayService.getAll();
        return ResponseEntity.ok(result);
    }
	
}
