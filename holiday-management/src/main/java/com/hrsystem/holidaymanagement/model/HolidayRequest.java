package com.hrsystem.holidaymanagement.model;

public class HolidayRequest {
	
	private long id;
    private String startDate;
    private String endDate;
    private int numberDays;
    private boolean isPaidHoliday;
    private long employeeId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getNumberDays() {
		return numberDays;
	}
	public void setNumberDays(int numberDays) {
		this.numberDays = numberDays;
	}
	public boolean getIsPaidHoliday() {
		return isPaidHoliday;
	}
	public void setIsPaidHoliday(boolean isPaidHoliday) {
		this.isPaidHoliday = isPaidHoliday;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

    
    
}
