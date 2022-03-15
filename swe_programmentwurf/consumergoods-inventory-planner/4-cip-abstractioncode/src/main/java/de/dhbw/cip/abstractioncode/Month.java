package de.dhbw.cip.abstractioncode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Month {

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private int month;
	
	private Month() {
		super();
	}
	
	public Month(int month) {
		super();
		this.month = month;
	}
	
	public int getMonth() {
		return month;
	}
}
