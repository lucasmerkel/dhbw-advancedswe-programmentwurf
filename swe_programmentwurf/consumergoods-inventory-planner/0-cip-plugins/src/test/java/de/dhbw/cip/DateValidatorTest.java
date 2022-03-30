package de.dhbw.cip;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Test;

import de.dhbw.cip.abstractioncode.DateValidator;
import de.dhbw.cip.abstractioncode.Day;
import de.dhbw.cip.abstractioncode.DayOfYear;
import de.dhbw.cip.abstractioncode.Month;
import de.dhbw.cip.abstractioncode.Year;

public class DateValidatorTest {

	@Test
	public void checkDateValidatorForValideDate() {
		//Arange
		Day day = new Day(5);
		Month month = new Month(7);
		Year year = new Year(2022);
		DayOfYear dayOfYear = new DayOfYear(day, month);
		
		//Act
		boolean execption = DateValidator.validate(dayOfYear, year);
		
		//Assert
		assertTrue(execption);
	}
	
	@Test
	public void checkValidatorForInvalideDate() {
		//Arange
		Day day = new Day(32);
		Month month = new Month(7);
		Year year = new Year(2022);
		DayOfYear dayOfYear = new DayOfYear(day, month);
		
		//Act
		boolean execption = DateValidator.validate(dayOfYear, year);
		
		//Assert
		assertTrue(execption);
	}
	
	@Test
	public void checkValidatorForValideFebruaryDate() {
		//Arange
		Day day = new Day(22);
		Month month = new Month(2);
		Year year = new Year(2022);
		DayOfYear dayOfYear = new DayOfYear(day, month);
		
		//Act
		boolean execption = DateValidator.validate(dayOfYear, year);
		
		//Assert
		assertTrue(execption);
	}
	
	@Test
	public void checkValidatorForInvalideFebruaryDate() {
		//Arange
		Day day = new Day(29);
		Month month = new Month(2);
		Year year = new Year(2022);
		DayOfYear dayOfYear = new DayOfYear(day, month);
		
		//Act
		boolean execption = DateValidator.validate(dayOfYear, year);
		
		//Assert
		assertTrue(execption);
	}
	
	@Test
	public void checkValidatorForFebruaryDateInLeapYear() {
		//Arange
		Day day = new Day(29);
		Month month = new Month(2);
		Year year = new Year(2024);
		DayOfYear dayOfYear = new DayOfYear(day, month);
		
		//Act
		boolean execption = DateValidator.validate(dayOfYear, year);
		
		//Assert
		assertTrue(execption);
	}
}
