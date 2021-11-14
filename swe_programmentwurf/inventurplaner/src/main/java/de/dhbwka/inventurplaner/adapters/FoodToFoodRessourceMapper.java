package de.dhbwka.inventurplaner.adapters;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import de.dhbwka.inventurplaner.domain.Food;

@Component
public class FoodToFoodRessourceMapper implements Function<ConsumerGoodsRessource, ConsumerGoods> {

	//both methods for mapping domain class to ressource class
	public FoodRessource applyToRessource(Food food) {
        return mapToRessource(food);
    }

    private FoodRessource mapToRessource(Food food) {
    	//TODO no new object, instead update Ressource object
    	return new FoodRessource();
    }
    
    //both methods for mapping ressource class to domain class
	public Food applyToDomain(FoodRessource foodRessource) {
        return mapToDomain(foodRessource);
    }

    private Food mapToDomain(FoodRessource foodRessource) {
        return new Food();
    }
}
