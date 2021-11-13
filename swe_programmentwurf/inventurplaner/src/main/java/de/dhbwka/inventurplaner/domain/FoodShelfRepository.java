package de.dhbwka.inventurplaner.domain;

public interface FoodShelfRepository {

	public Iterable<FoodShelf> getAllConsumerGoods();
	
	public FoodShelf save(FoodShelf goods);
}
