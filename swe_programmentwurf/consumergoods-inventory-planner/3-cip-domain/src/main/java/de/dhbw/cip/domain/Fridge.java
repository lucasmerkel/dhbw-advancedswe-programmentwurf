package de.dhbw.cip.domain;


import javax.persistence.Entity;

@Entity
public class Fridge extends Storage {

	private Fridge() {
		super("");
	}
	
	public Fridge(String description) {
		super(description);
	}
}
