package de.dhbw.cip.abstractioncode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Day {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private final int day;
	
	private Day() {
		super();
		this.day = 0;
	}
	
	public Day(int day) {
		super();
		this.day = day;
	}
	
	public int getDay() {
		return day;
	}
}
