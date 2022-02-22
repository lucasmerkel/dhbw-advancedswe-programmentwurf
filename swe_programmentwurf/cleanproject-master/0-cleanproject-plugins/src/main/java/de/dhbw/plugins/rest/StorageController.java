package de.dhbw.plugins.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.dhbw.cleanproject.application.book.StorageApplicationService;
import de.dhbw.cleanproject.book.StorageResource;
import de.dhbw.cleanproject.book.FoodShelfResource;
import de.dhbw.cleanproject.book.FoodShelfToFoodShelfRessourceMapper;
import de.dhbw.cleanproject.book.FridgeResource;
import de.dhbw.cleanproject.book.FridgeToFridgeResourceMapper;

@RestController
@RequestMapping(value="/api")
public class StorageController {

    private StorageApplicationService storageApplicationService;

    private FridgeToFridgeResourceMapper fridgeToFridgeResourceMapper;
    private FoodShelfToFoodShelfRessourceMapper foodShelfToFoodShelfResourceMapper;

    @Autowired
    public StorageController(StorageApplicationService storageApplicationService, 
    		FridgeToFridgeResourceMapper fridgeToFridgeResourceMapper,
    		FoodShelfToFoodShelfRessourceMapper foodShelfRessourceMapper) {
        this.storageApplicationService = storageApplicationService;
        this.fridgeToFridgeResourceMapper = fridgeToFridgeResourceMapper;
        this.foodShelfToFoodShelfResourceMapper = foodShelfRessourceMapper;
    }
    
    //GET
    //Fridge
    @RequestMapping(value="fridge", method = RequestMethod.GET)
    public List<FridgeResource> getFridges() {
        return this.storageApplicationService.findAllFridges().stream()
                .map(fridgeToFridgeResourceMapper)
                .collect(Collectors.toList());
    }
    
    //GET
    //FoodShelf
    @RequestMapping(value="foodshelf", method = RequestMethod.GET)
    public List<FoodShelfResource> getFoodShelfs() {
        return this.storageApplicationService.findAllFoodShelfs().stream()
                .map(foodShelfToFoodShelfResourceMapper)
                .collect(Collectors.toList());
    }

}

