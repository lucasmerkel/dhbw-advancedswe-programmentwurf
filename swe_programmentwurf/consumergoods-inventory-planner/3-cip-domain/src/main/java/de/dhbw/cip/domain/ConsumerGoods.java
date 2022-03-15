package de.dhbw.cip.domain;

import org.apache.commons.lang3.Validate;

import de.dhbw.cip.abstractioncode.UnitOfMeasure;

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

}
