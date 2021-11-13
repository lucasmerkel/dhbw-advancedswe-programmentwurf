package de.dhbwka.inventurplaner.domain;

public interface FoodShelfRepository {

	public Iterable<FoodShelf> getAllFoodShels();
	
	public FoodShelf save(FoodShelf goods);
}
