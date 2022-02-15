package de.dhbw.cleanproject.abstractioncode.consumergoods;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class UnitOfMeasure {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "description")
	protected String description;
	@Column(name = "shortcut")
	protected String shortcut;
	@Column(name = "value")
	protected double value;
	
	public abstract String getDescription();
	public abstract String getShortcut();
	public abstract double getValue();
	public abstract void setValue(double newValue);
}
