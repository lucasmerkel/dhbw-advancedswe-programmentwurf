package de.dhbw.cleanproject.domain.book;

import java.util.List;

public interface FridgeRepository {
	
	public List<Fridge> getAllFridges();
	
	public Fridge save(Fridge goods);
}
