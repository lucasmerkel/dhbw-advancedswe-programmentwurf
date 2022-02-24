package de.dhbw.cleanproject.abstractioncode.consumergoods;

import javax.persistence.Entity;

@Entity
public class Volume extends UnitOfMeasure {

	private Volume() {
		super(0);
	}
	
	public Volume(double value) {
		super(value);
		this.description = "Milliliter";
		this.shortcut = "ml";
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
