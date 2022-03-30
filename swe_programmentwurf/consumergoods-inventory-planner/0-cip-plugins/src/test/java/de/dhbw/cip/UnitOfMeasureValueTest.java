package de.dhbw.cip;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.dhbw.cip.abstractioncode.Quantity;
import de.dhbw.cip.abstractioncode.Value;
import de.dhbw.cip.abstractioncode.ValueValidator;
import de.dhbw.cip.abstractioncode.Volume;
import de.dhbw.cip.abstractioncode.Weight;

public class UnitOfMeasureValueTest {

	@Test
	public void checkNotNegativeMeasureValue() {
		//Arange
		int negativeValue = -1;
		
		//Act
		boolean wrongValueValidation = ValueValidator.checkValidyOf(negativeValue);
		
		//Assert
		assertTrue(wrongValueValidation);		
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
