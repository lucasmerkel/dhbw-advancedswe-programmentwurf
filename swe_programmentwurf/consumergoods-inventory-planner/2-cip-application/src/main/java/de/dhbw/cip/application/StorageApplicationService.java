package de.dhbw.cip.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import de.dhbw.cip.domain.FoodShelf;
import de.dhbw.cip.domain.FoodShelfRepository;
import de.dhbw.cip.domain.Fridge;
import de.dhbw.cip.domain.FridgeRepository;

@Service
public class StorageApplicationService {

    private FridgeRepository fridgeRepository;
    private FoodShelfRepository foodshelfRepository;

    @Autowired
    public StorageApplicationService(FridgeRepository fridgeRepository, FoodShelfRepository foodshelfRepository) {
        this.fridgeRepository = fridgeRepository;
        this.foodshelfRepository = foodshelfRepository;
    }

    public List<Fridge> findAllFridges() {
        return this.fridgeRepository.getAllFridges();
    }
    
    public List<FoodShelf> findAllFoodShelfs() {
        return this.foodshelfRepository.getAllFoodShelfs();
    }
}
