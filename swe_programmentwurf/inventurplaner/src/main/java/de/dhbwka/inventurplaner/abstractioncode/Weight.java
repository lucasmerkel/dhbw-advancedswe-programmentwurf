package de.dhbwka.inventurplaner.abstractioncode;

public class Weight extends UnitOfMeasure{
	
	public Weight() {
		this.description = "Gramm";
		this.shortcut = "g";
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
