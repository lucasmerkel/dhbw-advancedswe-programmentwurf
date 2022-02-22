package de.dhbw.plugins.persistence.hibernate.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.dhbw.cleanproject.domain.book.Fridge;
import de.dhbw.cleanproject.domain.book.FridgeRepository;
import de.dhbw.cleanproject.domain.book.Storage;

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
