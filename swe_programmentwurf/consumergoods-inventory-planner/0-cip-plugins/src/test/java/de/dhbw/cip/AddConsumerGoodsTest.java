package de.dhbw.cip;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.mockito.Mockito;

import de.dhbw.cip.abstractioncode.Day;
import de.dhbw.cip.abstractioncode.DayOfYear;
import de.dhbw.cip.abstractioncode.Month;
import de.dhbw.cip.abstractioncode.Year;
import de.dhbw.cip.domain.BestBeforeDate;
import de.dhbw.cip.domain.ConsumerGoods;
import de.dhbw.cip.domain.Food;
import de.dhbw.cip.domain.ConsumerGoods.ConsumerGoodsBuilder;
import de.dhbw.cip.domain.ConsumerGoodsRepository;

public class AddConsumerGoodsTest {

	@Test
	public void checkAddValidConsumerGoods() {
		//Arange
		final ConsumerGoodsRepository consumerGoodsRepositoryMock = Mockito.mock(ConsumerGoodsRepository.class);
		Mockito.when(consumerGoodsRepositoryMock.findStoredConsumerGoodsWith(12345678901l)).thenReturn(Optional.empty());
		ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder(consumerGoodsRepositoryMock, 12345678901l, "Tomatoes", 1, 1, 2022, "Stk.", 3, "Fridge", "fridge in the kitchen");
    	
		//Act
    	boolean consumerGuidsBuilderValidationWithoutFoodDescprition = consumerGoodsBuilder.validate();
		
    	//Assert
		assertTrue(consumerGuidsBuilderValidationWithoutFoodDescprition);
	}
	
	@Test
	public void checkAddConsumerGoodsWithoutFoodDescription() {
		//Arange
		final ConsumerGoodsRepository consumerGoodsRepositoryMock = Mockito.mock(ConsumerGoodsRepository.class);
		Mockito.when(consumerGoodsRepositoryMock.findStoredConsumerGoodsWith(12345678901l)).thenReturn(Optional.empty());
		ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder(consumerGoodsRepositoryMock, 12345678901l, null, 1, 1, 2022, "Stk.", 3, "Fridge", "fridge in the kitchen");
    	
		
		//Act
    	boolean consumerGuidsBuilderValidationWithoutFoodDescprition = consumerGoodsBuilder.validate();
		
    	//Assert
		assertFalse(consumerGuidsBuilderValidationWithoutFoodDescprition);
	}
	
	@Test
	public void checkAddConsumerGoodsWithoutMeasure() {
		//Arange
		final ConsumerGoodsRepository consumerGoodsRepositoryMock = Mockito.mock(ConsumerGoodsRepository.class);
		Mockito.when(consumerGoodsRepositoryMock.findStoredConsumerGoodsWith(12345678901l)).thenReturn(Optional.empty());
		ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder(consumerGoodsRepositoryMock, 12345678901l, "Tomatoe", 1, 1, 2022, null, 3, "Fridge", "fridge in the kitchen");
		
		//Act
		boolean consumerGoodsBuilderValidationWithoutMeasure = consumerGoodsBuilder.validate();
		
		//Assert
		assertFalse(consumerGoodsBuilderValidationWithoutMeasure);
	}
	
	@Test
	public void checkAddConsumerGoodsWithoutStorage() {
		//Arange
		final ConsumerGoodsRepository consumerGoodsRepositoryMock = Mockito.mock(ConsumerGoodsRepository.class);
		Mockito.when(consumerGoodsRepositoryMock.findStoredConsumerGoodsWith(12345678901l)).thenReturn(Optional.empty());
		ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder(consumerGoodsRepositoryMock, 12345678901l, "Tomatoe", 1, 1, 2022, "Stk.", 3, null, "fridge in the kitchen");
		
		//Act
		boolean consumerGuidsBuilderValidationWithoutStorage = consumerGoodsBuilder.validate();
		
		//Assert
		assertFalse(consumerGuidsBuilderValidationWithoutStorage);
	}
	
	/*
	@Test
	public void checkAddConsumerGoodsWithoutDate() {
		//Arange
		ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder("Tomatoe", (Integer) null, (Integer) null, (Integer) null, "Stk.", 3, null, "fridge in the kitchen");
		
		//Act
		boolean consumerGuidsBuilderValidationWithoutDate = consumerGoodsBuilder.validate();
		
		//Assert
		assertFalse(consumerGuidsBuilderValidationWithoutDate);
	}
	
	@Test
	public void checkAddConsumerGoodsWithoutMeasureValue() {
		//Arange
		ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder("Tomatoe", 1, 1, 2022, "Stk.", (Integer) null, "Fridge", "fridge in the kitchen");
		
		//Act
		boolean consumerGuidsBuilderValidationWithoutMeasureValue = consumerGoodsBuilder.validate();
		
		//Assert
		assertFalse(consumerGuidsBuilderValidationWithoutMeasureValue);
	}
	*/
}
