package de.dhbw.cip.domain;

import java.util.List;

public interface FridgeRepository {
	
	public Iterable<Fridge> getAllOccupiedFridgeStorageBins();
	
	public Fridge occupyPlaceAt(Fridge place);
}
