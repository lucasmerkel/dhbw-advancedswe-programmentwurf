package de.dhbw.cip.adapters;

import javax.persistence.Column;

import de.dhbw.cip.abstractioncode.UnitOfMeasure;

public abstract class StorageResource {
	
	protected Long id;
	protected String description;	
	public String classType;
	
	public StorageResource(long id, String description, String classType) {
		this.id = id;
		this.description = description;
		this.classType = classType;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getClassType() {
		return this.classType;
	}
	
	public long getId() {
		return this.id;
	}
}
