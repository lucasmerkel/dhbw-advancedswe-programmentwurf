package de.dhbw.cleanproject.book;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import de.dhbw.cleanproject.domain.book.Fridge;

@Component
public class FridgeToFridgeResourceMapper implements Function<Fridge, FridgeResource> {

    @Override
    public FridgeResource apply(Fridge fridge) {
        return map(fridge);
    }

    private FridgeResource map(Fridge fridge) {
        //return new ConsumerGoodsResource(consumerGoods.getTitle());
    	return new FridgeResource(fridge.getDescription());
    }

}
