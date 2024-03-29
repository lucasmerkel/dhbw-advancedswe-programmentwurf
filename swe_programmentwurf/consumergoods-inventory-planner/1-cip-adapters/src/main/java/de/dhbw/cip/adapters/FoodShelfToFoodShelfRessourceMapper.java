package de.dhbw.cip.adapters;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import de.dhbw.cip.domain.FoodShelf;

@Component
public class FoodShelfToFoodShelfRessourceMapper implements Function<FoodShelf, FoodShelfResource> {

    @Override
    public FoodShelfResource apply(FoodShelf foodShelf) {
        return map(foodShelf);
    }

    private FoodShelfResource map(FoodShelf foodShelf) {
    	return new FoodShelfResource(foodShelf.getId(), foodShelf.getDescription(), foodShelf.getClass().getSimpleName());
    }

}
