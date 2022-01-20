package de.dhbwka.inventurplaner.domain;

public abstract class Storage {

	protected String description;
	public abstract Object getClassType();
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
