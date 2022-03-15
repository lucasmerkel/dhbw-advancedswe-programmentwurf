package de.dhbw.cip.adapters;

import java.time.format.DateTimeParseException;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import de.dhbw.cip.abstractioncode.DateValidator;
import de.dhbw.cip.abstractioncode.DayOfYear;
import de.dhbw.cip.abstractioncode.Year;

public class BestBeforeDateResource {
	
	private Long id;
	private DayOfYear dayOfYear;
	private Year year;

	public BestBeforeDateResource(DayOfYear dayOfYear, Year year) {
		try {
		DateValidator.validate(dayOfYear, year);
		} catch(DateTimeParseException e) {
			e.printStackTrace();
			System.out.println("Input is an invalid date!");
		}
		this.dayOfYear = dayOfYear;
		this.year = year;
	}
	
	public int getDay() {
		return dayOfYear.getDay();
	}
	
	public int getMonth() {
		return dayOfYear.getMonth();
	}
	
	public int getYear() {
		return year.getYear();
	}
}
