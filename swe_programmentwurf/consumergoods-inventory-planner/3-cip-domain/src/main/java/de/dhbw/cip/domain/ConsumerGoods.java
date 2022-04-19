package de.dhbw.cip.domain;

import de.dhbw.cip.abstractioncode.Day;
import de.dhbw.cip.abstractioncode.DayOfYear;
import de.dhbw.cip.abstractioncode.Month;
import de.dhbw.cip.abstractioncode.Quantity;
import de.dhbw.cip.abstractioncode.UnitOfMeasure;
import de.dhbw.cip.abstractioncode.Value;
import de.dhbw.cip.abstractioncode.Volume;
import de.dhbw.cip.abstractioncode.Weight;
import de.dhbw.cip.abstractioncode.Year;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ConsumerGoods {
	
    @Id
    @Column
    private Long eanCode;

    @OneToOne(cascade = CascadeType.ALL)
    private Food food;
	
    @OneToOne(cascade=CascadeType.ALL)
    private UnitOfMeasure quantity;
    
    @OneToOne(cascade=CascadeType.ALL)
	private Storage storagePlace;
	
    private ConsumerGoods() {
    }
    
    public ConsumerGoods(ConsumerGoodsBuilder consumerGoodsBuilder) {
    	this.eanCode = consumerGoodsBuilder.eanCode;
        this.food = consumerGoodsBuilder.food;
		this.quantity = consumerGoodsBuilder.quantity;
		this.storagePlace = consumerGoodsBuilder.storage;
    }
    
    public Long getEANCode() {
        return eanCode;
    }
   
	public UnitOfMeasure getQuantity() {
		return this.quantity;
	}
	
	public Food getFood() {
		return this.food;
	}
	
	public Storage getStorage() {
		return this.storagePlace;
	}
	
	public void changeFood(Food food) {
		this.food = food;
	}
	
	public void changeUnitOfMeasure(UnitOfMeasure quantity) {
		this.quantity = quantity;
	}
	
	public void changeStoragePlace(Storage storagePlace) {
		this.storagePlace = storagePlace;
	}

	
	public static class ConsumerGoodsBuilder {

		private long eanCode;
        private final Food food;
		private final UnitOfMeasure quantity;
		private final Storage storage;

		public ConsumerGoodsBuilder(long eanCode, String foodDescription, 
				int day, int month, int year, 
				String measureShortcut, int measureValue, String storageTitle, String storageDescription) {
			
			this.eanCode = eanCode;
			this.food = new Food(foodDescription, new BestBeforeDate(new DayOfYear(new Day(day), new Month(month)), new Year(year)));
			this.quantity = findMeasureWith(measureShortcut, measureValue);
			this.storage = findStorageWith(storageTitle, storageDescription);
		}
		
		private UnitOfMeasure findMeasureWith(String measureShortcut, int measureValue) {
			if(measureShortcut == null) return null;
			if(measureShortcut.equals( new Weight(new Value(0)).getShortcut() ) ) return new Weight(new Value(measureValue));
			if(measureShortcut.equals( new Volume(new Value(0)).getShortcut() ) ) return new Volume(new Value(measureValue));
			if(measureShortcut.equals( new Quantity(new Value(0)).getShortcut() ) ) return new Quantity(new Value(measureValue));
			return null;
		}
		
		private Storage findStorageWith(String storageTitle, String storageDescription) {
			if(storageTitle == null) return null;
			if (Fridge.class.getSimpleName().equals(storageTitle) && storageDescription != null ) return new Fridge(storageDescription);
			if (FoodShelf.class.getSimpleName().equals(storageTitle) && storageDescription != null ) return new FoodShelf(storageDescription);
			return null;
		}
		
		public long getEANCode() {
			return this.eanCode;
		}
		
		public Food getFood() {
			return this.food;
		}
		
		public UnitOfMeasure getUnitOfMeasure() {
			return this.quantity;
		}
		
		public Storage getStorage() {
			return this.getStorage();
		}
		
		public boolean validate() {
			try {
				checkNonNull();
				boolean dateValidationResult = DateValidator.validate(new DayOfYear(new Day(food.getBbd().getDay()), 
																						new Month(food.getBbd().getMonth())), 
																							new Year(food.getBbd().getYear()));

				if(DayValidator.checkValidyOf( food.getBbd().getDay()) 
						&& MonthValidator.checkValidyOf(food.getBbd().getMonth())
						&& YearValidator.checkValidyOf(food.getBbd().getYear()) 
						&& ValueValidator.checkValidyOf(quantity.getValue().getValue()) 
						&& dateValidationResult ) return true;
				
				return false;
			}catch (Exception e) {
				return false;
			}
		}
		
		private void checkNonNull() {
			Objects.requireNonNull(eanCode, "EANCode must not be null");
			Objects.requireNonNull(food.getDescription(), "Food description must not be null");
			Objects.requireNonNull(food.getBbd().getDay(), "Best before date day must not be null");
			Objects.requireNonNull(food.getBbd().getMonth(), "Best before date month must not be null");
			Objects.requireNonNull(food.getBbd().getYear(), "Best before date year must not be null");
			Objects.requireNonNull(quantity, "quantity must not be null");
			Objects.requireNonNull(storage, "storage must not be null");
		}
		
		public ConsumerGoods build() {
			ConsumerGoods consumerGoods =  new ConsumerGoods(this);
			return consumerGoods;
		}
	}
}
