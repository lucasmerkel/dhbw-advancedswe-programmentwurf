package de.dhbw.cip.plugins.persistence.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.dhbw.cip.domain.Fridge;
import de.dhbw.cip.domain.FridgeRepository;

@Repository
public class FridgeRepositoryBridge implements FridgeRepository {
	
	private PersistenceFridgeRepository springDataFridgeRepository;

	@Autowired
    public FridgeRepositoryBridge(PersistenceFridgeRepository springDataFridgeRepository) {
        this.springDataFridgeRepository = springDataFridgeRepository;
    }

	@Override
	public Iterable<Fridge> getAllOccupiedFridgeStorageBins() {
		return this.springDataFridgeRepository.findAll();
	}

	@Override
	public Fridge occupyFridgeStorageBin(Fridge fridge) {
		return this.springDataFridgeRepository.save(fridge);
	}

}
