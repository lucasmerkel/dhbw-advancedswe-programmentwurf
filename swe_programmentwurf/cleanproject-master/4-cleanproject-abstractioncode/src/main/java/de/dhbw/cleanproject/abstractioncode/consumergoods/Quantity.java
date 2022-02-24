package de.dhbw.cleanproject.abstractioncode.consumergoods;

import javax.persistence.Entity;

@Entity
public class Quantity extends UnitOfMeasure {

	private Quantity() {
		super(0);
	}
	
	public Quantity(double value) {
		super(value);
		this.description = "Stueck";
		this.shortcut = "Stk.";
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
