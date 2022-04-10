package de.dhbw.cip.domain;

public class MonthValidator {

	public static boolean checkValidyOf(int date) {
		if(date > 0 && date <= 12) {
			return true;
		}
		//throw new IllegalArgumentException(String.valueOf(date)+" as value is not valid for month date");
		return false;
	}
}
