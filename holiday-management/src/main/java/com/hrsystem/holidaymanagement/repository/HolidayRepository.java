package com.hrsystem.holidaymanagement.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hrsystem.holidaymanagement.model.Holiday;

@Repository
public interface HolidayRepository extends MongoRepository<Holiday, Long> {
	List<Holiday> findByEmployeeId(Long employeeId);
}
