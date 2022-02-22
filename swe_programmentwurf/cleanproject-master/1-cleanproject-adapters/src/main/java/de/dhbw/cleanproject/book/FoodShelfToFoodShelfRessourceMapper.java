package de.dhbw.cleanproject.book;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import de.dhbw.cleanproject.domain.book.FoodShelf;

@Component
public class FoodShelfToFoodShelfRessourceMapper implements Function<FoodShelf, FoodShelfResource> {

    @Override
    public FoodShelfResource apply(FoodShelf foodShelf) {
        return map(foodShelf);
    }

    private FoodShelfResource map(FoodShelf foodShelf) {
        //return new ConsumerGoodsResource(consumerGoods.getTitle());
    	return new FoodShelfResource(foodShelf.getDescription());
    }

}
