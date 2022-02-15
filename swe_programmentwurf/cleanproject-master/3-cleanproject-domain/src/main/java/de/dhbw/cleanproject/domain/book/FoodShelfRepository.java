package de.dhbw.cleanproject.domain.book;

public interface FoodShelfRepository {

	public Iterable<FoodShelf> getAllFoodShels();
	
	public FoodShelf save(FoodShelf goods);
}
