package de.dhbw.cleanproject.book;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.Validate;

import de.dhbw.cleanproject.abstractioncode.consumergoods.UnitOfMeasure;
import de.dhbw.cleanproject.domain.book.Food;
import de.dhbw.cleanproject.domain.book.Storage;

public class ConsumerGoodsResource {

	 private long id;
	 private Food food;
	 private UnitOfMeasure quantity;
	 
	 private String storagePlace;
	 private ConsumerGoodsResource() {
		 //default constructor for JPA
	 }

	 public ConsumerGoodsResource(long id, Food food, UnitOfMeasure quantityValue, Storage storage) {
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
		
	public Food getFood() {
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
		
	public void changeStoragePlace(Storage storagePlace) {
		this.storagePlace = storagePlace.getDescription();
	}

}
