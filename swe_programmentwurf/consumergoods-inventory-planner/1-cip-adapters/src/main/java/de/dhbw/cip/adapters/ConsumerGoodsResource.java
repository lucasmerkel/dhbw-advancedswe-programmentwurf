package de.dhbw.cip.adapters;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.Validate;

import de.dhbw.cip.abstractioncode.UnitOfMeasure;
import de.dhbw.cip.domain.Food;
import de.dhbw.cip.domain.Storage;

public class ConsumerGoodsResource {

	 private long id;
	 private FoodResource food;
	 private UnitOfMeasure quantity;
	 
	 private String storagePlace;
	 private ConsumerGoodsResource() {
		 //default constructor for JPA
	 }

	 public ConsumerGoodsResource(long id, FoodResource food, UnitOfMeasure quantityValue, StorageResource storage) {
	    //Validate.notBlank(title);
	    //this.title = title;
		this.id = id;
	    this.food = food;
	    this.quantity = quantityValue;
		this.storagePlace = storage.getDescription();
	 }

	 //public String getTitle() {
	    //    return title;
	    //}
	   
	public long getId() {
		return id;
	}
	
	public UnitOfMeasure getQuantity() {
		return this.quantity;
	}
		
	public FoodResource getFood() {
		return this.food;
	}
		
	public String getStorage() {
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
		
	public void changeStoragePlace(StorageResource storagePlace) {
		this.storagePlace = storagePlace.getDescription();
	}

}
