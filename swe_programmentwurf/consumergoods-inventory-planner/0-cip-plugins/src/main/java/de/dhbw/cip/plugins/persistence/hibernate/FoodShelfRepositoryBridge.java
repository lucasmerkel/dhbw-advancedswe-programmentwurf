package de.dhbw.cip.plugins.persistence.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.dhbw.cip.domain.FoodShelf;
import de.dhbw.cip.domain.FoodShelfRepository;
import de.dhbw.cip.domain.Fridge;

@Repository
public class FoodShelfRepositoryBridge implements FoodShelfRepository {
	
	private PersistenceFoodShelfRepository springDataFoodShelfRepository;

	@Autowired
    public FoodShelfRepositoryBridge(PersistenceFoodShelfRepository springDataFoodShelfRepository) {
        this.springDataFoodShelfRepository = springDataFoodShelfRepository;
    }

	@Override
	public List<FoodShelf> getAllOccupiedFoodShelfStorageBins() {
		return this.springDataFoodShelfRepository.findAll();
	}

	@Override
	public FoodShelf occupyFoodShelfStorageBin(FoodShelf foodShelf) {
		return this.springDataFoodShelfRepository.save(foodShelf);
	}

}
