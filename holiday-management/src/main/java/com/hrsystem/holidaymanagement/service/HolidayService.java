package com.hrsystem.holidaymanagement.service;

import java.util.List;

import com.hrsystem.holidaymanagement.model.Holiday;
import com.hrsystem.holidaymanagement.model.HolidayRequest;

public interface HolidayService {
	Holiday save(HolidayRequest holiday);
	List<Holiday> findByEmployeeId(Long id);
	List<Holiday> getAll();
}
