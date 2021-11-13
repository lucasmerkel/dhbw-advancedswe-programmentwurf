package de.dhbwka.inventurplaner.domain;

public interface FridgeRepository {
	
	public Iterable<Fridge> getAllConsumerGoods();
	
	public Fridge save(Fridge goods);
}
