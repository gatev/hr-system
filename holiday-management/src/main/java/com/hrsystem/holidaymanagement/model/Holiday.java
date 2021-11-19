package com.hrsystem.holidaymanagement.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "holiday")
@Data
public class Holiday {
	@Id
	private String id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int numberDays;
    private boolean isPaidHoliday;
    private long employeeId;
}
