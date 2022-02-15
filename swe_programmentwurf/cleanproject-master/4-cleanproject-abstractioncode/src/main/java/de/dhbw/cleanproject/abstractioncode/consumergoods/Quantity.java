package de.dhbw.cleanproject.abstractioncode.consumergoods;

import javax.persistence.Entity;

@Entity
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
	public void setValue(double newValue) {
		this.value = newValue;
	}

	@Override
	public String getShortcut() {
		return this.shortcut;
	}
}