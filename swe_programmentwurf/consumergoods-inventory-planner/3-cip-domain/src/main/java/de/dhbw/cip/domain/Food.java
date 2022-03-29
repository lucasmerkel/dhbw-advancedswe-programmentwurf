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
@Table(name = "Food")
public class Food {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "description")
	private final String description;
	
	@OneToOne(cascade=CascadeType.ALL)
	private final BestBeforeDate bbd;
	
	private Food() {
        //default constructor for JPA
		this.description = "";
		this.bbd = new BestBeforeDate(new DayOfYear(new Day(0), new Month(0)), new Year(0));
    }
	
	public Food(String description, BestBeforeDate bbd) {
		this.description = description;
		this.bbd = bbd;
	}
	
	public BestBeforeDate getBbd() {
		return this.bbd;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	/*
	public void setDescription(String description) {
		this.description = description;
	}
	
	//Classes instead of String
	public void setBbd(BestBeforeDate bbd) {
		this.bbd = bbd;
	}
	*/
}
