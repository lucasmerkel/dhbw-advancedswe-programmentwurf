package de.dhbw.cip.adapters;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.Validate;

import de.dhbw.cip.abstractioncode.UnitOfMeasure;
import de.dhbw.cip.domain.Food;
import de.dhbw.cip.domain.Storage;

public class ConsumerGoodsResource {

	 private long eanCode;
	 private FoodResource food;
	 private UnitOfMeasure quantity;
	 
	 private StorageResource storagePlace;
	 private ConsumerGoodsResource() {
		 //default constructor for JPA
	 }

	 public ConsumerGoodsResource(long eanCode, FoodResource food, UnitOfMeasure quantityValue, StorageResource storage) {
	    //Validate.notBlank(title);
	    //this.title = title;
		this.eanCode = eanCode;
	    this.food = food;
	    this.quantity = quantityValue;
		this.storagePlace = storage;
	 }

	 //public String getTitle() {
	    //    return title;
	    //}
	   
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
