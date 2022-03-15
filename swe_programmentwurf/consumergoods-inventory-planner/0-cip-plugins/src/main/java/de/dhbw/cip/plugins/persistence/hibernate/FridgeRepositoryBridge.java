package de.dhbw.cip.plugins.persistence.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.dhbw.cip.domain.Fridge;
import de.dhbw.cip.domain.FridgeRepository;
import de.dhbw.cip.domain.Storage;

@Repository
public class FridgeRepositoryBridge implements FridgeRepository {
	
	private SpringDataFridgeRepository springDataFridgeRepository;

	@Autowired
    public FridgeRepositoryBridge(SpringDataFridgeRepository springDataFridgeRepository) {
        this.springDataFridgeRepository = springDataFridgeRepository;
    }

	@Override
	public List<Fridge> getAllFridges() {
		return this.springDataFridgeRepository.findAll();
	}

	@Override
	public Fridge save(Fridge fridge) {
		return this.springDataFridgeRepository.save(fridge);
	}

}
