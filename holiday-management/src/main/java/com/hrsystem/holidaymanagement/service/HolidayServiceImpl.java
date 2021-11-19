package com.hrsystem.holidaymanagement.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrsystem.holidaymanagement.model.Holiday;
import com.hrsystem.holidaymanagement.model.HolidayRequest;
import com.hrsystem.holidaymanagement.repository.HolidayRepository;

@Service
public class HolidayServiceImpl implements HolidayService {
	
	private HolidayRepository holidayRepository;
	
	@Autowired
	public HolidayServiceImpl(HolidayRepository holidayRepository) {
		this.holidayRepository = holidayRepository;
	}

	@Override
	public Holiday save(HolidayRequest holidayRequest) {
		Holiday holiday = new Holiday();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate startDate = LocalDate.parse(holidayRequest.getStartDate(), formatter);
		LocalDate endDate = LocalDate.parse(holidayRequest.getEndDate(), formatter);
		holiday.setId(UUID.randomUUID().toString());
		holiday.setStartDate(startDate);
		holiday.setEndDate(endDate);
		holiday.setPaidHoliday(holidayRequest.getIsPaidHoliday());
		holiday.setEmployeeId(holidayRequest.getEmployeeId());
		holiday.setNumberDays(holidayRequest.getNumberDays());
		return holidayRepository.save(holiday);
	}

	@Override
	public List<Holiday> findByEmployeeId(Long id) {
		return holidayRepository.findByEmployeeId(id);
	}

	@Override
	public List<Holiday> getAll() {
		return holidayRepository.findAll();
	}

}
