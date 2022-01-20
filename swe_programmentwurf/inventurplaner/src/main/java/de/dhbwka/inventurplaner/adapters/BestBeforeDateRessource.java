package de.dhbwka.inventurplaner.adapters;

import de.dhbwka.inventurplaner.abstractioncode.DateValidator;

public class BestBeforeDateRessource {

		private int day;
		private int month;
		private int year;
		
		//Classes instead String
		public BestBeforeDateRessource(int day, int month, int year) {
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