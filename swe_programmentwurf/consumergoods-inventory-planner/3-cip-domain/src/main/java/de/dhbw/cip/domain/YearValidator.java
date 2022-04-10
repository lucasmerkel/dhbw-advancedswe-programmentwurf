package de.dhbw.cip.domain;

public class YearValidator {

	public static boolean checkValidyOf(int date) {
		if(date >= 0) {
			return true;
		}
		//throw new IllegalArgumentException(String.valueOf(date)+" as value is not valid for year date");
		return false;
	}
}
