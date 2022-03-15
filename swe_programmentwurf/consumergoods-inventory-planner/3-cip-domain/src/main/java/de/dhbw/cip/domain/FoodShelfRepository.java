package de.dhbw.cip.domain;

import java.util.List;

public interface FoodShelfRepository {

	public List<FoodShelf> getAllFoodShelfs();
	
	public FoodShelf save(FoodShelf goods);
}
