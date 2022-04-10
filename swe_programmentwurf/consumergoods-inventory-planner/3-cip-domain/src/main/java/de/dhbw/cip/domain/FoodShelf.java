package de.dhbw.cip.domain;

import javax.persistence.Entity;

@Entity
public class FoodShelf extends Storage {
	
	private FoodShelf() {
		super("");
	}
	
	public FoodShelf(String description) {
		super(description);
	}
}
