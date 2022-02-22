package de.dhbw.cleanproject.domain.book;

import java.util.List;

public interface FoodShelfRepository {

	public List<FoodShelf> getAllFoodShelfs();
	
	public FoodShelf save(FoodShelf goods);
}
