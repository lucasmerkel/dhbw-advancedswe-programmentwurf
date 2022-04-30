package de.dhbw.cip.adapters;

import de.dhbw.cip.abstractioncode.UnitOfMeasure;


public class ConsumerGoodResource {

	 private long eanCode;
	 private FoodResource food;
	 private UnitOfMeasure quantity;
	 private StorageResource storagePlace;
	 
	 private ConsumerGoodResource() {
	 }

	 public ConsumerGoodResource(long eanCode, FoodResource food, UnitOfMeasure quantityValue, StorageResource storage) {
		this.eanCode = eanCode;
	    this.food = food;
	    this.quantity = quantityValue;
		this.storagePlace = storage;
	 }
	   
	public long getEANCode() {
		return eanCode;
	}
	
	public UnitOfMeasure getQuantity() {
		return this.quantity;
	}
		
	public FoodResource getFood() {
		return this.food;
	}
		
	public String getStorage() {
		return this.storagePlace.getDescription();
	}
	
	public String getStorageType() {
		return this.storagePlace.getClassType();
	}
		
	public void changeFoodDescription(String description) {
		this.food.setDescription(description);
	}
		
	//TODO
	public void changeFoodBestBeforedate() {
		
	}
		
	public void changeStoragePlace(StorageResource storagePlace) {
		this.storagePlace = storagePlace;
	}
}
