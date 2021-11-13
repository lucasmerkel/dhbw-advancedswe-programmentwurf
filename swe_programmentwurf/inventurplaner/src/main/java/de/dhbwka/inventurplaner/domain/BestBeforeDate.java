package de.dhbwka.inventurplaner.domain;

import java.util.Date;

import de.dhbwka.inventurplaner.abstractioncode.DateValidator;

public class BestBeforeDate {

	private String day;
	private String month;
	private String year;
	
	//Classes instead String
	public BestBeforeDate(String day, String month, String year) {
		DateValidator.validate(day, month, year);
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public String getDay() {
		return day;
	}
	
	public String getMonth() {
		return month;
	}
	
	public String getYear() {
		return year;
	}
	
	//TODO
	public void setDate() {
		DateValidator.validate();
	}
}
