package de.dhbw.cip.domain;

public interface FoodShelfRepository {

	public Iterable<FoodShelf> getAllOccupiedFoodShelfStorageBins();
	
	public FoodShelf occupyPlaceAt(FoodShelf place);
}
