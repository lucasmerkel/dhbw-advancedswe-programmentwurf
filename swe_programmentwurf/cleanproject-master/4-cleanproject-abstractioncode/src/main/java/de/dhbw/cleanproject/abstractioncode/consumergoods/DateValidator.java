package de.dhbw.cleanproject.abstractioncode.consumergoods;

public class DateValidator {
	
	public static boolean validate(int day, int month, int year) {
		if(month == 2) return checkFebruary(day, month, year);
		return checkNotFebruary(day, month, year);
	}
	
	private static boolean checkFebruary(int day, int month, int year) {
		if(year % 4 == 0 && year % 100 != 0 || month % 400 == 0) return checkTwentyNineDays(day);
		return checkTwentyEightDays(day);
	}
	
	private static boolean checkNotFebruary(int day, int month, int year) {
		if(month < 8 && month % 2 != 0) return checkThirdyOneDays(day);
		if(month > 8 && month % 2 == 0) return checkThirdyOneDays(day);
		return checkThirdyDays(day);
	}
	
	private static boolean checkThirdyOneDays(int day) {
		return day <= 31;
	}
	
	private static boolean checkThirdyDays(int day) {
		return day <= 30;
	}
	
	private static boolean checkTwentyNineDays(int day) {
		return day <= 29;
	}
	
	private static boolean checkTwentyEightDays(int day) {
		return day <= 28;
	}
}
