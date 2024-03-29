package de.dhbw.cip;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.dhbw.cip.domain.MonthValidator;

public class MonthDateValidationTest {
	
	/*
	 * #Requirement
	 * #Regression
	 */
	@Test
	public void checkNotNegativeOrZeroMonthDate() {
		//Arange
		int negativeDateForMonth = -1;
		int zeroDateForMonth = 0;
		//Act
		boolean negativeDateValidation = MonthValidator.checkValidyOf(negativeDateForMonth);
		boolean zeroDateValidation = MonthValidator.checkValidyOf(zeroDateForMonth);
		
		//Assert
		assertFalse(negativeDateValidation);
		assertFalse(zeroDateValidation);
	}
	
	/*
	 * #Requirement
	 * #Bugfix
	 */
	@Test
	public void checkMonthDateOver12NotAllowed() {
		//Arange
		int wrongDateForMonth = 13;
		//Act
		boolean wrongDateValidation = MonthValidator.checkValidyOf(wrongDateForMonth);
		
		//Assert
		assertFalse(wrongDateValidation);
		
	}
	
	/*
	 * #Requirement
	 */
	@Test
	public void checkMonthDateAllowed() {
		//Arange
		int dateForMonth = 2;
		//Act
		boolean validDateValidation = MonthValidator.checkValidyOf(dateForMonth);
		
		//Assert
		assertTrue(validDateValidation);
	}
}
