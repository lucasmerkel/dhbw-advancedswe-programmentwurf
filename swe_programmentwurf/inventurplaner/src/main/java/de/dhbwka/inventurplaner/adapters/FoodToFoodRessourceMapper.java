package de.dhbwka.inventurplaner.adapters;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import de.dhbwka.inventurplaner.domain.ConsumerGoods;
import de.dhbwka.inventurplaner.domain.Food;

@Component
public class FoodToFoodRessourceMapper implements Function<FoodRessource, Food> {

	//both methods for mapping domain class to ressource class
	public FoodRessource applyToRessource(Food food) {
        return mapToRessource(food);
    }

    private FoodRessource mapToRessource(Food food) {
    	//TODO no new object, instead update Ressource object
    	return new FoodRessource(food.getDescription(), food.getBbd());
    }
    
    //both methods for mapping ressource class to domain class
	public Food applyToDomain(FoodRessource foodRessource) {
        return mapToDomain(foodRessource);
    }

    private Food mapToDomain(FoodRessource foodRessource) {
        return new Food(foodRessource.getDescription(), foodRessource.getBbd());
    }

	public ConsumerGoods apply(ConsumerGoodsRessource t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Food apply(FoodRessource t) {
		// TODO Auto-generated method stub
		return null;
	}
}
