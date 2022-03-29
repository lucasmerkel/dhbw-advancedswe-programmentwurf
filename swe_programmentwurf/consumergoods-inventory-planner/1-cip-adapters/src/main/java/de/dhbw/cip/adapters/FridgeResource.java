package de.dhbw.cip.adapters;

public class FridgeResource extends StorageResource{
	
	private FridgeResource() {
		 //default constructor for JPA
	}
	
	public FridgeResource(long id, String description) {
		this.id = id;
		this.description = description;
	}
	
	@Override
	public Object getClassType() {
		// TODO Auto-generated method stub
		return null;
	}

}
