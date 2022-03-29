package de.dhbw.cip.abstractioncode;

import javax.persistence.Entity;

@Entity
public class Quantity extends UnitOfMeasure {

	private Quantity() {
		super(new Value(0));
	}
	
	public Quantity(Value value) {
		super(value);
		this.description = "Stueck";
		this.shortcut = "Stk.";
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
