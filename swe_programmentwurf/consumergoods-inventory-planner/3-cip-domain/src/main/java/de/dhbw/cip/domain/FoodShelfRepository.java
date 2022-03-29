package de.dhbw.cip.domain;

import java.util.List;

public interface FoodShelfRepository {

	public List<FoodShelf> getAllOccupiedFoodShelfStorageBins();
	
	public FoodShelf occupyFoodShelfStorageBin(FoodShelf goods);
}
