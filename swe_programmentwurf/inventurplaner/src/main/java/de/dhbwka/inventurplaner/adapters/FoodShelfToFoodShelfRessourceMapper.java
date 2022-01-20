package de.dhbwka.inventurplaner.adapters;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import de.dhbwka.inventurplaner.domain.FoodShelf;

@Component
public class FoodShelfToFoodShelfRessourceMapper implements Function<FoodShelfRessource, FoodShelf> {

	//both methods for mapping domain class to ressource class
	public FoodShelfRessource applyToRessource(FoodShelf foodShelf) {
        return mapToRessource(foodShelf);
    }

    private FoodShelfRessource mapToRessource(FoodShelf foodShelf) {
    	//TODO no new object, instead update Ressource object
    	return new FoodShelfRessource(foodShelf.getDescription());
    }
    
    //both methods for mapping ressource class to domain class
	public FoodShelf applyToDomain(FoodShelfRessource foodShelfRessource) {
        return mapToDomain(foodShelfRessource);
    }

    private FoodShelf mapToDomain(FoodShelfRessource foodShelfRessource) {
        return new FoodShelf(foodShelfRessource.getDescription());
    }

	public FoodShelf apply(FoodShelfRessource foodShelfRessource) {
		// TODO Auto-generated method stub
		return null;
	}
}
