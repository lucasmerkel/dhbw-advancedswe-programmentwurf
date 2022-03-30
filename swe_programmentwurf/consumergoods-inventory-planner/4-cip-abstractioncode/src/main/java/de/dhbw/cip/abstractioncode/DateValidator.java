package de.dhbw.cip.abstractioncode;

import java.time.format.DateTimeParseException;

public class DateValidator {
	
	public static boolean validate(DayOfYear dayOfYear, Year year) {
		if(!checkDate(dayOfYear, year)) {
			return false;
			//throw new DateTimeParseException("Input is an invalid date!", String.valueOf(dayOfYear.getDay()), 0);
		}
		return true;
	}
	
	private static boolean checkDate(DayOfYear dayOfYear, Year year) {
		if(dayOfYear.getMonth() == 2) return checkFebruary(dayOfYear, year);
		return checkNotFebruary(dayOfYear);
	}
	
	private static boolean checkFebruary(DayOfYear dayOfYear, Year year) {
		if(year.getYear() % 4 == 0 && year.getYear() % 100 != 0 || dayOfYear.getMonth() % 400 == 0) return checkTwentyNineDays(dayOfYear);
		return checkTwentyEightDays(dayOfYear);
	}
	
	private static boolean checkNotFebruary(DayOfYear dayOfYear) {
		if(dayOfYear.getMonth() < 8 && dayOfYear.getMonth() % 2 != 0) return checkThirdyOneDays(dayOfYear);
		if(dayOfYear.getMonth() > 8 && dayOfYear.getMonth() % 2 == 0) return checkThirdyOneDays(dayOfYear);
		return checkThirdyDays(dayOfYear);
	}
	
	private static boolean checkThirdyOneDays(DayOfYear dayOfYear) {
		return dayOfYear.getDay() <= 31;
	}
	
	private static boolean checkThirdyDays(DayOfYear dayOfYear) {
		return dayOfYear.getDay() <= 30;
	}
	
	private static boolean checkTwentyNineDays(DayOfYear dayOfYear) {
		return dayOfYear.getDay() <= 29;
	}
	
	private static boolean checkTwentyEightDays(DayOfYear dayOfYear) {
		return dayOfYear.getDay() <= 28;
	}
}
