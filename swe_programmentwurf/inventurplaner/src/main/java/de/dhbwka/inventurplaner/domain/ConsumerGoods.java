package de.dhbwka.inventurplaner.domain;

import de.dhbwka.inventurplaner.abstractioncode.UnitOfMeasure;

public class ConsumerGoods {
	
	private Food food;
	private UnitOfMeasure quantity;
	private Storage storagePlace;
	
	public ConsumerGoods(Food food, UnitOfMeasure quantityValue, Storage storage) {
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
