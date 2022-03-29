package de.dhbw.cip.abstractioncode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DayOfYear {

		@Id
    	@Column(name = "id")
    	@GeneratedValue(strategy = GenerationType.AUTO)
    	private Long id;
	
		@OneToOne(cascade = CascadeType.ALL)
		private final Day day;
		
		@OneToOne(cascade = CascadeType.ALL)
		private final Month month;
		
		private DayOfYear() {
			super();
			this.day = new Day(0);
			this.month = new Month(0);
		}
		
		public DayOfYear(Day day, Month month) {
			super();
			this.day = day;
			this.month = month;
		}
		
		public int getDay() {
			return day.getDay();
		}
		
		public int getMonth() {
			return month.getMonth();
		}
}
