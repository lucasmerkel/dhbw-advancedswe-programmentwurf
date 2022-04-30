package de.dhbw.cip.adapters;

import org.springframework.stereotype.Component;

import de.dhbw.cip.abstractioncode.Day;
import de.dhbw.cip.abstractioncode.DayOfYear;
import de.dhbw.cip.abstractioncode.Month;
import de.dhbw.cip.abstractioncode.Year;
import de.dhbw.cip.domain.ConsumerGood;
import de.dhbw.cip.domain.Fridge;

import java.util.function.Function;

@Component
public class ConsumerGoodToConsumerGoodResourceMapper implements Function<ConsumerGood, ConsumerGoodResource> {

    @Override
    public ConsumerGoodResource apply(ConsumerGood consumerGoods) {
        return map(consumerGoods);
    }

    private ConsumerGoodResource map(ConsumerGood consumerGoods) {
    	if(consumerGoods.getStorage() instanceof Fridge) return new ConsumerGoodResource(consumerGoods.getEANCode(), 
    			new FoodResource(consumerGoods.getFood().getDescription(), 
    			new BestBeforeDateResource(new DayOfYear(new Day(consumerGoods.getFood().getBestBeforeDate().getDay()), 
    														new Month(consumerGoods.getFood().getBestBeforeDate().getMonth())),
    															new Year(consumerGoods.getFood().getBestBeforeDate().getYear()))),
    			consumerGoods.getQuantity(), 
    			new FridgeResource(consumerGoods.getStorage().getId(),
    					consumerGoods.getStorage().getDescription(), 
    					consumerGoods.getStorage().getClass().getSimpleName()));
    	
    	return new ConsumerGoodResource(consumerGoods.getEANCode(), new FoodResource(consumerGoods.getFood().getDescription(), 
    			new BestBeforeDateResource(new DayOfYear(new Day(consumerGoods.getFood().getBestBeforeDate().getDay()), 
    														new Month(consumerGoods.getFood().getBestBeforeDate().getMonth())),
    															new Year(consumerGoods.getFood().getBestBeforeDate().getYear()))),
    			consumerGoods.getQuantity(), 
    			new FoodShelfResource(consumerGoods.getStorage().getId(), 
    					consumerGoods.getStorage().getDescription(),
    					consumerGoods.getStorage().getClass().getSimpleName()));
    }
}
