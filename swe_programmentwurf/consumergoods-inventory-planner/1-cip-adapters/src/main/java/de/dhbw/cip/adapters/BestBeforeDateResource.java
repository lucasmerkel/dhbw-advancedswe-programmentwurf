package de.dhbw.cip.adapters;

import de.dhbw.cip.abstractioncode.DayOfYear;
import de.dhbw.cip.abstractioncode.Year;

public class BestBeforeDateResource {
	
	private DayOfYear dayOfYear;
	private Year year;

	public BestBeforeDateResource(DayOfYear dayOfYear, Year year) {
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
