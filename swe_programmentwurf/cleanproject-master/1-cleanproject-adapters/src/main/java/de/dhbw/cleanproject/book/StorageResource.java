package de.dhbw.cleanproject.book;

import javax.persistence.Column;

public abstract class StorageResource {
	private Long id;
	protected String description;	
	public abstract Object getClassType();
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
