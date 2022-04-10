package de.dhbw.cip.domain;

public class ValueValidator {
	
	public static boolean checkValidyOf(int value) {
		if(value > 0 ) {
			return true;
		}
		//throw new IllegalArgumentException(String.valueOf(value)+" as value is not valid");
		return false;
	}
}
