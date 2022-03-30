package de.dhbw.cip;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.easymock.EasyMock;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import de.dhbw.cip.application.ConsumerGoodsManager;
import de.dhbw.cip.plugins.persistence.hibernate.ConsumerGoodsRepositoryBridge;

public class DeleteConsumerGoodsTest {
	
	@Autowired
	@Test
	public void checkDeletionOfConsumerGoods() {
		//Arange		
		final ConsumerGoodsRepositoryBridge consumerGoodsRepository = Mockito.mock(ConsumerGoodsRepositoryBridge.class);
		Mockito.when(consumerGoodsRepository.outsourceConsumerGoods(1)).thenReturn(true);
		
		//Act
		//boolean outsourceConsumerGoodsFlag = consumerGoodsManager.deleteConsumerGoods(1);
		
		//Assert
		//assertTrue(outsourceConsumerGoodsFlag);
		
		//Verify
		Mockito.verify(consumerGoodsRepository, Mockito.times(1));
	}
}
