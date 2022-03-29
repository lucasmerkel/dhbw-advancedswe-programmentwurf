package de.dhbw.cip.adapters;

import javax.persistence.Column;

import de.dhbw.cip.abstractioncode.UnitOfMeasure;

public abstract class StorageResource {
	
	protected Long id;
	protected String description;	
	public abstract Object getClassType();
	
	public void setDescription(long id, String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public long getId() {
		return this.id;
	}
}
