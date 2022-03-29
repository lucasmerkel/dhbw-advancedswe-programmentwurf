package de.dhbw.cip.abstractioncode;

import javax.persistence.Entity;

@Entity
public class Weight extends UnitOfMeasure{
	
	private Weight() {
		super(new Value(0));
	}
	
	public Weight(Value value) {
		super(value);
		this.description = "Gramm";
		this.shortcut = "g";
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public Value getValue() {
		return this.value;
	}

	@Override
	public String getShortcut() {
		return this.shortcut;
	}

}
