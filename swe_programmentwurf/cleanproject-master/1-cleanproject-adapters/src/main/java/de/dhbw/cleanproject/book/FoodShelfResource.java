package de.dhbw.cleanproject.book;

public class FoodShelfResource extends StorageResource {
	
	private FoodShelfResource() {
		 //default constructor for JPA
	 }
	
	public FoodShelfResource(String description) {
		this.description = description;
	}

	@Override
	public Object getClassType() {
		// TODO Auto-generated method stub
		return null;
	}

}
