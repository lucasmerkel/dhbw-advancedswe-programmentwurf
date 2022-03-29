package de.dhbw.cip.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Storage {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "description")
	protected String description;
	
	//public abstract Object getClassType();
	
	/*public void setDescription(String description) {
		this.description = description;
	}*/
	public long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
}
