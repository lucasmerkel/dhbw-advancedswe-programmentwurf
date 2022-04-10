package de.dhbw.cip.adapters;

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
