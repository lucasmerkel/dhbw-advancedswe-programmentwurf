package de.dhbw.cip.abstractioncode;

import javax.persistence.Entity;

@Entity
public class Volume extends UnitOfMeasure {

	private Volume() {
		super(new Value(0));
	}
	
	public Volume(Value value) {
		super(value);
		this.description = "Milliliter";
		this.shortcut = "ml";
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
