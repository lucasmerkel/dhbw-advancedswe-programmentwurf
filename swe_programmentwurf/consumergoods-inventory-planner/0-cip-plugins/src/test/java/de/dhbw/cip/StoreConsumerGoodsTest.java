package de.dhbw.cip;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.mockito.Mockito;

import de.dhbw.cip.domain.ConsumerGoods.ConsumerGoodsBuilder;
import de.dhbw.cip.domain.ConsumerGoodsRepository;

public class StoreConsumerGoodsTest {

	@Test
	public void checkStoreValidConsumerGood() {
		//Capture
		final ConsumerGoodsRepository consumerGoodsRepositoryMock = Mockito.mock(ConsumerGoodsRepository.class);
		Mockito.when(consumerGoodsRepositoryMock.findStoredConsumerGoodsWith(12345678901l)).thenReturn(Optional.empty());
		
		//Arange
		ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder(consumerGoodsRepositoryMock, 12345678901l, "Tomatoes", 1, 1, 2022, "Stk.", 3, "Fridge", "fridge in the kitchen");
    	
		//Act
    	boolean consumerGuidsBuilderValidationWithoutFoodDescprition = consumerGoodsBuilder.validate();
		
    	//Assert
		assertTrue(consumerGuidsBuilderValidationWithoutFoodDescprition);
	}
	
	@Test
	public void checkStoreConsumerGoodWithoutFoodDescription() {
		//Capture
		final ConsumerGoodsRepository consumerGoodsRepositoryMock = Mockito.mock(ConsumerGoodsRepository.class);
		Mockito.when(consumerGoodsRepositoryMock.findStoredConsumerGoodsWith(12345678901l)).thenReturn(Optional.empty());
		
		//Arange
		ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder(consumerGoodsRepositoryMock, 12345678901l, null, 1, 1, 2022, "Stk.", 3, "Fridge", "fridge in the kitchen");
    	
		
		//Act
    	boolean consumerGuidsBuilderValidationWithoutFoodDescprition = consumerGoodsBuilder.validate();
		
    	//Assert
		assertFalse(consumerGuidsBuilderValidationWithoutFoodDescprition);
	}
	
	@Test
	public void checkStoreConsumerGoodWithoutMeasure() {
		//Capture
		final ConsumerGoodsRepository consumerGoodsRepositoryMock = Mockito.mock(ConsumerGoodsRepository.class);
		Mockito.when(consumerGoodsRepositoryMock.findStoredConsumerGoodsWith(12345678901l)).thenReturn(Optional.empty());
		
		//Arange
		ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder(consumerGoodsRepositoryMock, 12345678901l, "Tomatoe", 1, 1, 2022, null, 3, "Fridge", "fridge in the kitchen");
		
		//Act
		boolean consumerGoodsBuilderValidationWithoutMeasure = consumerGoodsBuilder.validate();
		
		//Assert
		assertFalse(consumerGoodsBuilderValidationWithoutMeasure);
	}
	
	@Test
	public void checkStoreConsumerGoodWithoutStorage() {
		//Capture
		final ConsumerGoodsRepository consumerGoodsRepositoryMock = Mockito.mock(ConsumerGoodsRepository.class);
		Mockito.when(consumerGoodsRepositoryMock.findStoredConsumerGoodsWith(12345678901l)).thenReturn(Optional.empty());
		
		//Arange
		ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder(consumerGoodsRepositoryMock, 12345678901l, "Tomatoe", 1, 1, 2022, "Stk.", 3, null, "fridge in the kitchen");
		
		//Act
		boolean consumerGuidsBuilderValidationWithoutStorage = consumerGoodsBuilder.validate();
		
		//Assert
		assertFalse(consumerGuidsBuilderValidationWithoutStorage);
	}
}
