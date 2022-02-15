package de.dhbw.cleanproject.domain.book;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import de.dhbw.cleanproject.abstractioncode.consumergoods.DateValidator;

@Entity
@Table(name = "BestBeforeDate")
public class BestBeforeDate {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "day")
	private int day;
	@Column(name = "month")
	private int month;
	@Column(name = "year")
	private int year;
	
	private BestBeforeDate() {
		
	}
	
	//Classes instead String
	public BestBeforeDate(int day, int month, int year) {
		DateValidator.validate(day, month, year);
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	//TODO
	public void setDate(int day, int month, int year) {
		if(!DateValidator.validate(day, month, year)) return;
		
		this.day = day;
		this.month = month;
		this.year = year;
	}
}
