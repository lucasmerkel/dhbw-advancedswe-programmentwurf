package de.dhbw.cip.domain;

import java.util.List;

public interface FridgeRepository {
	
	public List<Fridge> getAllOccupiedFridgeStorageBins();
	
	public Fridge occupyFridgeStorageBin(Fridge goods);
}
