package de.dhbw.cip;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.dhbw.cip.domain.ConsumerGoods.ConsumerGoodsBuilder;

public class AddConsumerGoodsTest {

	@Test
	public void checkAddValidConsumerGoods() {
		//Arange
		ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder("Tomatoes", 1, 1, 2022, "Stk.", 3, "Fridge", "fridge in the kitchen");
    	
		//Act
    	boolean consumerGuidsBuilderValidationWithoutFoodDescprition = consumerGoodsBuilder.validate();
		
    	//Assert
		assertTrue(consumerGuidsBuilderValidationWithoutFoodDescprition);
	}
	
	@Test
	public void checkAddConsumerGoodsWithoutFoodDescription() {
		//Arange
		ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder(null, 1, 1, 2022, "Stk.", 3, "Fridge", "fridge in the kitchen");
    	
		
		//Act
    	boolean consumerGuidsBuilderValidationWithoutFoodDescprition = consumerGoodsBuilder.validate();
		
    	//Assert
		assertFalse(consumerGuidsBuilderValidationWithoutFoodDescprition);
	}
	
	@Test
	public void checkAddConsumerGoodsWithoutMeasure() {
		//Arange
		ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder("Tomatoe", 1, 1, 2022, null, 3, "Fridge", "fridge in the kitchen");
		
		//Act
		boolean consumerGoodsBuilderValidationWithoutMeasure = consumerGoodsBuilder.validate();
		
		//Assert
		assertFalse(consumerGoodsBuilderValidationWithoutMeasure);
	}
	
	@Test
	public void checkAddConsumerGoodsWithoutStorage() {
		//Arange
		ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder("Tomatoe", 1, 1, 2022, "Stk.", 3, null, "fridge in the kitchen");
		
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
