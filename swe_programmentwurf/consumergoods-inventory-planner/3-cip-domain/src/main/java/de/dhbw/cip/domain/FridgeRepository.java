package de.dhbw.cip.domain;

import java.util.List;

public interface FridgeRepository {
	
	public List<Fridge> getAllFridges();
	
	public Fridge save(Fridge goods);
}
