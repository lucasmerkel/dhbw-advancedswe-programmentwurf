package de.dhbw.cip.adapters;


public class FoodResource {
	
	private String description;
	private BestBeforeDateResource bbd;
	
	public FoodResource(String description, BestBeforeDateResource bbd) {
		this.description = description;
		this.bbd = bbd;
	}
	
	public BestBeforeDateResource getBbd() {
		return this.bbd;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setBbd(BestBeforeDateResource bbd) {
		this.bbd = bbd;
	}
}
