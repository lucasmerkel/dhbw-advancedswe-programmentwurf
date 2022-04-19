package de.dhbw.cip;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.dhbw.cip.domain.YearValidator;

public class YearDateValidationTest {

	@Test
	public void checkNotNegativeYearDate() {
		//Arange
		int negativeDateForYear = -1;

		//Act
		boolean negativeDateValidation = YearValidator.checkValidyOf(negativeDateForYear);

		//Assert
		assertFalse(negativeDateValidation);
	}

	@Test
	public void checkYearDateAllowed() {
		//Arange
		int dateForYear = 2022;
		//Act
		boolean validDateValidation = YearValidator.checkValidyOf(dateForYear);
		
		//Assert
		assertTrue(validDateValidation);
	}
}
