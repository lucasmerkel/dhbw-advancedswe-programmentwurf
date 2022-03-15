package de.dhbw.cip.domain;

import java.time.format.DateTimeParseException;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import de.dhbw.cip.abstractioncode.DateValidator;
import de.dhbw.cip.abstractioncode.DayOfYear;
import de.dhbw.cip.abstractioncode.Year;

@Entity
@Table(name = "BestBeforeDate")
public class BestBeforeDate {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private DayOfYear dayOfYear;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Year year;
	
	private BestBeforeDate() {
		
	}
	
	public BestBeforeDate(DayOfYear dayOfYear, Year year) {
		try {
		DateValidator.validate(dayOfYear, year);
		} catch(DateTimeParseException e) {
			e.printStackTrace();
			System.out.println("Input is an invalid date!");
		}
		this.dayOfYear = dayOfYear;
		this.year = year;
	}
	
	public int getDay() {
		return dayOfYear.getDay();
	}
	
	public int getMonth() {
		return dayOfYear.getMonth();
	}
	
	public int getYear() {
		return year.getYear();
	}
	/*
	//TODO
	public void setDate(int day, int month, int year) {
		if(!DateValidator.validate(day, month, year)) return;
		
		this.day = day;
		this.month = month;
		this.year = year;
	}
	*/
}
