package de.dhbwka.inventurplaner.domain;

public class Food {

	private String description;
	private BestBeforeDate bbd;
	
	public Food(String description, BestBeforeDate bbd) {
		this.description = description;
		this.bbd = bbd;
	}
	
	public BestBeforeDate getBbd() {
		return bbd;
	}
	
	public String getDescription() {
		return description;
	}
}
