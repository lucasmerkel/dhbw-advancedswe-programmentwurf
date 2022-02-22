package de.dhbw.plugins.persistence.hibernate.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.dhbw.cleanproject.domain.book.FoodShelf;
import de.dhbw.cleanproject.domain.book.FoodShelfRepository;
import de.dhbw.cleanproject.domain.book.Fridge;

@Repository
public class FoodShelfRepositoryBridge implements FoodShelfRepository {
	
	private SpringDataFoodShelfRepository springDataFoodShelfRepository;

	@Autowired
    public FoodShelfRepositoryBridge(SpringDataFoodShelfRepository springDataFoodShelfRepository) {
        this.springDataFoodShelfRepository = springDataFoodShelfRepository;
    }
	
	@Override
	public List<FoodShelf> getAllFoodShelfs() {
		return this.springDataFoodShelfRepository.findAll();
	}

	@Override
	public FoodShelf save(FoodShelf foodShelf) {
		return this.springDataFoodShelfRepository.save(foodShelf);
	}

}
