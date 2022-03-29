package de.dhbw.cip.domain;

import org.apache.commons.lang3.Validate;

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
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ConsumerGoods")
public class ConsumerGoods {
	
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@Column(name = "title")
    //private String title;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Food food;
	
    @OneToOne(cascade=CascadeType.ALL)
    private UnitOfMeasure quantity;
    
    @OneToOne(cascade=CascadeType.ALL)
	private Storage storagePlace;
	
    private ConsumerGoods() {
        //default constructor for JPA
    }

    public ConsumerGoods(Food food, UnitOfMeasure quantityValue, Storage storage) {
    	//Validate.notBlank(title);
        //this.title = title;
        
        this.food = food;
		this.quantity = quantityValue;
		this.storagePlace = storage;
    }
    
    public ConsumerGoods(ConsumerGoodsBuilder consumerGoodsBuilder) {
    	//Validate.notBlank(title);
        //this.title = title;
        
        this.food = consumerGoodsBuilder.food;
		this.quantity = consumerGoodsBuilder.quantity;
		this.storagePlace = consumerGoodsBuilder.storage;
    }

    //public String getTitle() {
    //    return title;
    //}
    
    public Long getId() {
        return id;
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
	
	public void changeFoodDescription(String description) {
		this.food.setDescription(description);
	}
	
	public void changeFoodBestBeforedate(BestBeforeDate bbd) {
		this.food.setBbd(bbd);
	}
	
	public void changeQuantity(UnitOfMeasure quantity) {
		this.quantity = quantity;
	}
	
	public void changeStoragePlace(Storage storagePlace) {
		this.storagePlace = storagePlace;
	}

	
	public static class ConsumerGoodsBuilder {
		
        private final Food food;
		private final UnitOfMeasure quantity;
		private final Storage storage;

		public ConsumerGoodsBuilder(String description, int day, int month, int year, String measureShortcut, int measureValue, String storageTitle, String storageDescription) {
			food = new Food(description, new BestBeforeDate(new DayOfYear(new Day(day), new Month(month)), new Year(year)));
			quantity = findMeasureWith(measureShortcut, measureValue);
		    storage = findStorageWith(storageTitle, storageDescription);
		}
		
		private UnitOfMeasure findMeasureWith(String measureShortcut, int measureValue) {
			if(measureShortcut.equals("g") ) return new Weight(new Value(measureValue));
			if(measureShortcut.equals("ml") ) return new Volume(new Value(measureValue));
			//default is quantity
			return new Quantity(new Value(measureValue));
		}
		
		private Storage findStorageWith(String storageTitle, String storageDescription) {
			if (Fridge.class.getSimpleName().equals(storageTitle)) return new Fridge(storageDescription);
			//default is FoodShelf
			return new FoodShelf(storageDescription);
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
		//Return the finally consrcuted User object
		public ConsumerGoods build() {
			ConsumerGoods consumerGoods =  new ConsumerGoods(this);
			return consumerGoods;
		}
	}
}
