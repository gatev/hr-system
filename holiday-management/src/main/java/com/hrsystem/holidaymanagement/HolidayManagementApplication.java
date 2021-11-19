package com.hrsystem.holidaymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.hrsystem.holidaymanagement.repository.HolidayRepository;

@SpringBootApplication
public class HolidayManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolidayManagementApplication.class, args);
	}

}
