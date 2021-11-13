package de.dhbwka.inventurplaner.abstractioncode;

public class Quantity extends UnitOfMeasure {

	public Quantity() {
		this.description = "Stueck";
		this.shortcut = "Stk.";
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
	public void setValue(double wertNeu) {
		this.value = wertNeu;
	}

	@Override
	public String getShortcut() {
		return this.shortcut;
	}
}
