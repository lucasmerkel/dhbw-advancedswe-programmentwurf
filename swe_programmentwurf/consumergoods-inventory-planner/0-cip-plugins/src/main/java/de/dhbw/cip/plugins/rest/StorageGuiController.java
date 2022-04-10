package de.dhbw.cip.plugins.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.dhbw.cip.adapters.FoodShelfResource;
import de.dhbw.cip.adapters.FoodShelfToFoodShelfRessourceMapper;
import de.dhbw.cip.adapters.FridgeResource;
import de.dhbw.cip.adapters.FridgeToFridgeResourceMapper;
import de.dhbw.cip.adapters.StorageResource;
import de.dhbw.cip.application.StorageManager;

@RestController
@RequestMapping(value="/api")
public class StorageGuiController {

    private StorageManager storageApplicationService;

    private FridgeToFridgeResourceMapper fridgeToFridgeResourceMapper;
    private FoodShelfToFoodShelfRessourceMapper foodShelfToFoodShelfResourceMapper;

    @Autowired
    public StorageGuiController(StorageManager storageApplicationService, 
    		FridgeToFridgeResourceMapper fridgeToFridgeResourceMapper,
    		FoodShelfToFoodShelfRessourceMapper foodShelfRessourceMapper) {
        this.storageApplicationService = storageApplicationService;
        this.fridgeToFridgeResourceMapper = fridgeToFridgeResourceMapper;
        this.foodShelfToFoodShelfResourceMapper = foodShelfRessourceMapper;
    }
    
    //GET
    //Fridge
    @RequestMapping(value="/fridge", method = RequestMethod.GET)
    public Iterable<FridgeResource> getFridges() {
    	return StreamSupport.stream(this.storageApplicationService.findAllFridges().spliterator(), false)
    			.map(fridgeToFridgeResourceMapper)
    			.collect(Collectors.toList());
    /*	return this.storageApplicationService.findAllFridges().stream()
                .map(fridgeToFridgeResourceMapper)
                .collect(Collectors.toList());
    */
    }
    
    //GET
    //FoodShelf
    @RequestMapping(value="/foodshelf", method = RequestMethod.GET)
    public Iterable<FoodShelfResource> getFoodShelfs() {
    	return StreamSupport.stream(this.storageApplicationService.findAllFoodShelfs().spliterator(), false)
    			.map(foodShelfToFoodShelfResourceMapper)
    			.collect(Collectors.toList());
    /*	return this.storageApplicationService.findAllFoodShelfs().stream()
                .map(foodShelfToFoodShelfResourceMapper)
                .collect(Collectors.toList());
    */
    }

}

