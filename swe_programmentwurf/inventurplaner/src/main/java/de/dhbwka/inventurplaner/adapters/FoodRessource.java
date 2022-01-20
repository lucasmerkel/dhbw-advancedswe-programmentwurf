package de.dhbwka.inventurplaner.adapters;

import de.dhbwka.inventurplaner.domain.BestBeforeDate;

public class FoodRessource {

	private String description;
	private BestBeforeDate bbd;
	
	public FoodRessource(String description, BestBeforeDate bbd) {
		this.description = description;
		this.bbd = bbd;
	}
	
	public BestBeforeDate getBbd() {
		return this.bbd;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	//Classes instead of String
	public void setBbd(int day, int month, int year) {
		this.bbd.setDate(day, month, year);
	}
}
