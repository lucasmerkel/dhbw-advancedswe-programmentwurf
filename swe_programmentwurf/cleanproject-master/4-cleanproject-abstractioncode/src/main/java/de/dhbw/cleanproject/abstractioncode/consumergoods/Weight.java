package de.dhbw.cleanproject.abstractioncode.consumergoods;

import javax.persistence.Entity;

@Entity
public class Weight extends UnitOfMeasure{
	
	private Weight() {
		super(0);
	}
	
	public Weight(double value) {
		super(value);
		this.description = "Gramm";
		this.shortcut = "g";
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
