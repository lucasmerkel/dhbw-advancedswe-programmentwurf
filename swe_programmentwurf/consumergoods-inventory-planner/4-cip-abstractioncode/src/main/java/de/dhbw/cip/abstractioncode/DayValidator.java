package de.dhbw.cip.abstractioncode;

public class DayValidator {

	public static boolean checkValidyOf(int date) {
		if(date > 0 && date <= 31) {
			return true;
		}
		//throw new IllegalArgumentException(String.valueOf(date)+" as value is not valid for day date");
		return false;
	}
}
