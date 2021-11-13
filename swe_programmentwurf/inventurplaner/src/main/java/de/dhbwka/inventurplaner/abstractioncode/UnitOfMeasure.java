package de.dhbwka.inventurplaner.abstractioncode;

public abstract class UnitOfMeasure {
	
	protected String description;
	protected String shortcut;
	protected double value;
	
	public abstract String getDescription();
	public abstract String getShortcut();
	public abstract double getValue();
	public abstract void setValue(double newValue);
}
