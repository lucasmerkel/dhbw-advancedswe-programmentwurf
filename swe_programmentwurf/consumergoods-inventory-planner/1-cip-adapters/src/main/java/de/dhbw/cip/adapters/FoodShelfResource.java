package de.dhbw.cip.adapters;

public class FoodShelfResource extends StorageResource {
	
	private FoodShelfResource() {
		 //default constructor for JPA
	 }
	
	public FoodShelfResource(long id, String description) {
		this.id = id;
		this.description = description;
	}

	@Override
	public Object getClassType() {
		// TODO Auto-generated method stub
		return null;
	}

}
