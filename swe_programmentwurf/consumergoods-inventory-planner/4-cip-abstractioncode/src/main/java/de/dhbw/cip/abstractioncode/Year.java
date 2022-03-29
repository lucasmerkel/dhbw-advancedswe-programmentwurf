package de.dhbw.cip.abstractioncode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Year {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private final int year;
	
	private Year() {
		super();
		this.year = 0;
	}
	
	public Year(int year) {
		super();
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
}