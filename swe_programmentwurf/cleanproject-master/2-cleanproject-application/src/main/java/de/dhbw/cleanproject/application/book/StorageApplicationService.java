package de.dhbw.cleanproject.application.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import de.dhbw.cleanproject.domain.book.FoodShelf;
import de.dhbw.cleanproject.domain.book.FoodShelfRepository;
import de.dhbw.cleanproject.domain.book.Fridge;
import de.dhbw.cleanproject.domain.book.FridgeRepository;

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
