package de.dhbwka.inventurplaner.domain;

import de.dhbwka.inventurplaner.abstractioncode.UnitOfMeasure;

public class ConsumerGoods {
	
	private Food food;
	private UnitOfMeasure quantity;
	
	public ConsumerGoods(Food food, UnitOfMeasure quantityValue) {
		this.food = food;
		this.quantity = quantityValue;
	}
	
	public UnitOfMeasure getQuantity() {
		return quantity;
	}
	
	public Food getFood() {
		return food;
	}
}
