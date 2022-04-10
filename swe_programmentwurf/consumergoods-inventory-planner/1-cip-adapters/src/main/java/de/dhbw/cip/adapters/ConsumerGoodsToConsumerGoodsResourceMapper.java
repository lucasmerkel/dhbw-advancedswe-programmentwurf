package de.dhbw.cip.adapters;

import org.springframework.stereotype.Component;

import de.dhbw.cip.abstractioncode.Day;
import de.dhbw.cip.abstractioncode.DayOfYear;
import de.dhbw.cip.abstractioncode.Month;
import de.dhbw.cip.abstractioncode.Year;
import de.dhbw.cip.domain.ConsumerGoods;
import de.dhbw.cip.domain.Fridge;

import java.util.function.Function;

@Component
public class ConsumerGoodsToConsumerGoodsResourceMapper implements Function<ConsumerGoods, ConsumerGoodsResource> {

    @Override
    public ConsumerGoodsResource apply(ConsumerGoods consumerGoods) {
        return map(consumerGoods);
    }

    private ConsumerGoodsResource map(ConsumerGoods consumerGoods) {
    	if(consumerGoods.getStorage() instanceof Fridge) return new ConsumerGoodsResource(consumerGoods.getEANCode(), 
    			new FoodResource(consumerGoods.getFood().getDescription(), 
    			new BestBeforeDateResource(new DayOfYear(new Day(consumerGoods.getFood().getBbd().getDay()), 
    														new Month(consumerGoods.getFood().getBbd().getMonth())),
    															new Year(consumerGoods.getFood().getBbd().getYear()))),
    			consumerGoods.getQuantity(), 
    			new FridgeResource(consumerGoods.getStorage().getId(),
    					consumerGoods.getStorage().getDescription(), 
    					consumerGoods.getStorage().getClass().getSimpleName()));
    	
    	return new ConsumerGoodsResource(consumerGoods.getEANCode(), new FoodResource(consumerGoods.getFood().getDescription(), 
    			new BestBeforeDateResource(new DayOfYear(new Day(consumerGoods.getFood().getBbd().getDay()), 
    														new Month(consumerGoods.getFood().getBbd().getMonth())),
    															new Year(consumerGoods.getFood().getBbd().getYear()))),
    			consumerGoods.getQuantity(), 
    			new FoodShelfResource(consumerGoods.getStorage().getId(), 
    					consumerGoods.getStorage().getDescription(),
    					consumerGoods.getStorage().getClass().getSimpleName()));
    }
}
