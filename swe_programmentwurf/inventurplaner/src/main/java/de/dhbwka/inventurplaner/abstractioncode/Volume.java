package de.dhbwka.inventurplaner.abstractioncode;

public class Volume extends UnitOfMeasure {

	public Volume() {
		this.description = "Milliliter";
		this.shortcut = "ml";
		this.value = 0;
	}
	
	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public void setValue(double newValue) {
		this.value = newValue;
	}

	@Override
	public String getShortcut() {
		return this.shortcut;
	}

}
