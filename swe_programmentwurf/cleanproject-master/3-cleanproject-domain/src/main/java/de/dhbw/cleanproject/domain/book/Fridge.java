package de.dhbw.cleanproject.domain.book;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

import javax.persistence.Entity;

@Entity
public class Fridge extends Storage {

	private Fridge() {
		
	}
	
	public Fridge(String description) {
		this.description = description;
	}

	@Override
	public Object getClassType() {
		return this.getClassType();
	}
}
