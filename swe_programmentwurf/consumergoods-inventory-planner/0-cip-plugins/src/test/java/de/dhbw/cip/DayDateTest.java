package de.dhbw.cip;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.dhbw.cip.abstractioncode.Day;
import de.dhbw.cip.domain.DayValidator;

public class DayDateTest {

	@Test
	public void checkNotNegativeOrZeroDayDate() {
		//Arange
		int negativeDateForDay = -1;
		int zeroDateForDay = 0;
		
		//Act
		boolean negativeDateValidation = DayValidator.checkValidyOf(negativeDateForDay);
		boolean zeroDateValidation = DayValidator.checkValidyOf(zeroDateForDay);
		
		//Assert
		assertFalse(negativeDateValidation);
		assertFalse(zeroDateValidation);
	}
	
	@Test
	public void checkDayDateOver31NotAllowed() {
		//Arange
		int wrongDateForDay = 32;
		
		//Act
		boolean wrongDateValidation = DayValidator.checkValidyOf(wrongDateForDay);
		
		//Assert
		assertFalse(wrongDateValidation);
	}
	
	@Test
	public void checkDayDateAllowed() {
		//Arange
		int dateForDay = 2;
		
		//Act
		boolean validDateValidation = DayValidator.checkValidyOf(dateForDay);
		
		//Assert
		assertTrue(validDateValidation);
	}
}
