package de.dhbw.cleanproject.domain.book;

public interface FridgeRepository {
	
	public Iterable<Fridge> getAllFridges();
	
	public Fridge save(Fridge goods);
}
