package de.dhbw.cip.adapters;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;

import de.dhbw.cip.domain.BestBeforeDate;

public class FoodResource {
	
	private Long id;
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
	
	//Classes instead of String
	public void setBbd(BestBeforeDateResource bbd) {
		this.bbd = bbd;
	}
}
