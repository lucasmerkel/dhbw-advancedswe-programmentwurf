package de.dhbwka.inventurplaner.application;

import org.springframework.beans.factory.annotation.Autowired;

import de.dhbwka.inventurplaner.domain.FoodShelf;
import de.dhbwka.inventurplaner.domain.FoodShelfRepository;

public class FoodShelfApplicationService {

	private FoodShelfRepository foodShelfRepository;

    @Autowired
    public FoodShelfApplicationService(FoodShelfRepository foodShelfRepository) {
        this.foodShelfRepository = foodShelfRepository;
    }

    public Iterable<FoodShelf> findFoodShelfs() {
        return this.foodShelfRepository.getAllFoodShels();
    }
}
