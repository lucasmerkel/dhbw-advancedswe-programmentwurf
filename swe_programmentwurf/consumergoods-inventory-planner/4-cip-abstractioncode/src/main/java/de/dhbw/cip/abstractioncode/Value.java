package de.dhbw.cip.abstractioncode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Value {
	
	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private final int value;
	
	private Value() {
		value = 0;
    }
	
	public Value(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
