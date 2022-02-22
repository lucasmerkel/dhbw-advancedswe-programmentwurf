package de.dhbw.cleanproject.book;

public class FridgeResource extends StorageResource{
	
	private FridgeResource() {
		 //default constructor for JPA
	 }
	
	public FridgeResource(String description) {
		this.description = description;
	}
	
	@Override
	public Object getClassType() {
		// TODO Auto-generated method stub
		return null;
	}

}
