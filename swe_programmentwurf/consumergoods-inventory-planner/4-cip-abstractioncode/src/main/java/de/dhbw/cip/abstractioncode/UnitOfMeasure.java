package de.dhbw.cip.abstractioncode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

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
	//@Column(name = "value")
	@OneToOne(cascade=CascadeType.ALL)
	protected Value value;
	
	public UnitOfMeasure(Value value) {
		this.value = value;
	}
	
	public abstract String getDescription();
	public abstract String getShortcut();
	public abstract Value getValue();
}
