package de.dhbw.cip;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.dhbw.cip.domain.ValueValidator;

public class UnitOfMeasureValueTest {

	@Test
	public void checkNotNegativeMeasureValue() {
		//Arange
		int negativeValue = -1;
		
		//Act
		boolean wrongValueValidation = ValueValidator.checkValidyOf(negativeValue);
		//Assert
		assertFalse(wrongValueValidation);		
	}
	
	@Test
	public void checkMeasureValue() {
		//Arange
		int validValue = 1;
		
		//Act
		boolean valueValidation = ValueValidator.checkValidyOf(validValue);
		
		//Assert
		assertTrue(valueValidation);	
	}
}
