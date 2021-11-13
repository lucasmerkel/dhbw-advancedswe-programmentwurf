package de.dhbwka.inventurplaner.domain;

public interface FridgeRepository {
	
	public Iterable<Fridge> getAllFridges();
	
	public Fridge save(Fridge goods);
}
