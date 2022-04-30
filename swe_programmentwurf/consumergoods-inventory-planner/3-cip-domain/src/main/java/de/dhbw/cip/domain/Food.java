package de.dhbw.cip.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import de.dhbw.cip.abstractioncode.Day;
import de.dhbw.cip.abstractioncode.DayOfYear;
import de.dhbw.cip.abstractioncode.Month;
import de.dhbw.cip.abstractioncode.Year;

@Entity
public class Food implements StorableGood {

	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column
	private final String description;
	
	@OneToOne(cascade=CascadeType.ALL)
	private final BestBeforeDate bbd;
	
	private Food() {
		this.description = "";
		this.bbd = new BestBeforeDate(new DayOfYear(new Day(0), new Month(0)), new Year(0));
    }
	
	public Food(String description, BestBeforeDate bbd) {
		this.description = description;
		this.bbd = bbd;
	}
	
	public BestBeforeDate getBestBeforeDate() {
		return this.bbd;
	}
	
	public String getDescription() {
		return this.description;
	}

	@Override
	public StorableGood getInstance() {
		return this;
	}

}
