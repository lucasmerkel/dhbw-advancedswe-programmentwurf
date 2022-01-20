package de.dhbwka.inventurplaner.adapters;

import de.dhbwka.inventurplaner.abstractioncode.UnitOfMeasure;
import de.dhbwka.inventurplaner.domain.Food;
import de.dhbwka.inventurplaner.domain.Storage;

public class ConsumerGoodsRessource {

	private Food food;
	private UnitOfMeasure quantity;
	private Storage storagePlace;
	
	public ConsumerGoodsRessource(Food food, UnitOfMeasure quantityValue, Storage storage) {
		this.food = food;
		this.quantity = quantityValue;
		this.storagePlace = storage;
	}
	
	public UnitOfMeasure getQuantity() {
		return this.quantity;
	}
	
	public Food getFood() {
		return this.food;
	}
	
	public Storage getStorage() {
		return this.storagePlace;
	}
	
	public void changeFoodDescription(String description) {
		this.food.setDescription(description);
	}
	
	//TODO
	public void changeFoodBestBeforedate() {
		
	}
	
	public void changeValue(double value) {
		this.quantity.setValue(value);
	}
	
	public void changeStoragePlace(Storage storagePlace) {
		this.storagePlace = storagePlace;
	}
}
