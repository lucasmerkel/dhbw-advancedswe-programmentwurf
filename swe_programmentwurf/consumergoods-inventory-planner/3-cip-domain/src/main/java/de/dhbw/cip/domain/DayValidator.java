package de.dhbw.cip.domain;

public class DayValidator {

	public static boolean checkValidyOf(int date) {
		return (date > 0 && date <= 31);
	}
}
