package de.dhbw.cip.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class FoodShelf extends Storage {
	
	private FoodShelf() {
		
	}
	
	public FoodShelf(String description) {
		this.description = description;
	}
	
	/*
	@Override
	public Object getClassType() {
		return this.getClassType();
	}*/
}
