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

import de.dhbw.cip.abstractioncode.Day;
import de.dhbw.cip.abstractioncode.DayOfYear;
import de.dhbw.cip.abstractioncode.Month;
import de.dhbw.cip.abstractioncode.Year;

@Entity
@Table(name = "BestBeforeDate")
public class BestBeforeDate {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private final DayOfYear dayOfYear;
	
	@OneToOne(cascade = CascadeType.ALL)
	private final Year year;
	
	private BestBeforeDate() {
		this.dayOfYear = new DayOfYear(new Day(0), new Month(0));
		this.year = new Year(0);
	}
	
	public BestBeforeDate(DayOfYear dayOfYear, Year year) {
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
}
