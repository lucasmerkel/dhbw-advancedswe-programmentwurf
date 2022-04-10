package de.dhbw.cip.domain;

public class MonthValidator {

	public static boolean checkValidyOf(int date) {
		return (date > 0 && date <= 12);
	}
}
