package de.dhbwka.inventurplaner.application;

import org.springframework.beans.factory.annotation.Autowired;

import de.dhbwka.inventurplaner.domain.Fridge;
import de.dhbwka.inventurplaner.domain.FridgeRepository;

public class FridgeApplicationService {

	private FridgeRepository fridgeRepository;

    @Autowired
    public FridgeApplicationService(FridgeRepository fridgeRepository) {
        this.fridgeRepository = fridgeRepository;
    }

    public Iterable<Fridge> findAllFridges() {
        return this.fridgeRepository.getAllFridges();
    }
}
