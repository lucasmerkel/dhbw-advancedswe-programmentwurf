package de.dhbw.cip;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import de.dhbw.cip.abstractioncode.Day;
import de.dhbw.cip.abstractioncode.DayOfYear;
import de.dhbw.cip.abstractioncode.Month;
import de.dhbw.cip.abstractioncode.Year;
import de.dhbw.cip.domain.BestBeforeDate;
import de.dhbw.cip.domain.ConsumerGoods;
import de.dhbw.cip.domain.Food;
import de.dhbw.cip.domain.Fridge;
import de.dhbw.cip.domain.ConsumerGoods.ConsumerGoodsBuilder;
import de.dhbw.cip.domain.ConsumerGoodsRepository;

public class UpdateConsumerGoodsTest {
	
	@Test
	public void checkUpdateOfConsumerGoods() {
	//Capture
	
		
	//Arange
	final ConsumerGoodsRepository consumerGoodsRepositoryMock = Mockito.mock(ConsumerGoodsRepository.class);
	Mockito.when(consumerGoodsRepositoryMock.findStoredConsumerGoodsWith(12345678901l)).thenReturn(Optional.empty());
	ConsumerGoods newConsumerGoods = new ConsumerGoodsBuilder(consumerGoodsRepositoryMock, 12345678901l, "Tomatoes", 3, 3, 2022, "Stk.", 1, "Fridge", "Mockup Fridge").build();
	
	final ConsumerGoods consumerGoodsMock = Mockito.mock(ConsumerGoods.class);
	Mockito.when(consumerGoodsMock.getFood()).thenReturn(new Food("Bananas", new BestBeforeDate(new DayOfYear(new Day(4), new Month(4)), new Year(2022))));
	//Mockito.when(consumerGoodsMock.getQuantity()).thenReturn(new Food());
	Mockito.when(consumerGoodsMock.getStorage()).thenReturn(new Fridge("Mocked Fridge"));
	
	//Act
	newConsumerGoods.changeFood(consumerGoodsMock.getFood());
	//newConsumerGoods.changeQuantity(consumerGoodsMock.getQuantity());
	newConsumerGoods.changeStoragePlace(consumerGoodsMock.getStorage());
	
	//Assert
	assertEquals(consumerGoodsMock.getFood(), newConsumerGoods.getFood());
	//assertEquals(consumerGoodsMock.getQuantity(), newConsumerGoods.getQuantity());
	assertEquals(consumerGoodsMock.getStorage(), newConsumerGoods.getStorage());
	
	//Verify
	Mockito.verify(consumerGoodsMock, Mockito.times(1));
	}
	
}
