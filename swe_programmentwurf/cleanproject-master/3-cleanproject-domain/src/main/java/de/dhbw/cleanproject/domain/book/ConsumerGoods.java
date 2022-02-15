package de.dhbw.cleanproject.domain.book;

import org.apache.commons.lang3.Validate;

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

    @Column(name = "title")
    private String title;

    private ConsumerGoods() {
        //default constructor for JPA
    }

    public ConsumerGoods(String title) {
        
    	Validate.notBlank(title);
        
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }
}
