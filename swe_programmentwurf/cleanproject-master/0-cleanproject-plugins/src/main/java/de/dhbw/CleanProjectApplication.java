package de.dhbw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.dhbw.cleanproject.abstractioncode.consumergoods.Quantity;
import de.dhbw.cleanproject.book.ConsumerGoodsResource;
import de.dhbw.cleanproject.domain.book.BestBeforeDate;
import de.dhbw.cleanproject.domain.book.ConsumerGoods;
import de.dhbw.cleanproject.domain.book.ConsumerGoodsRepository;
import de.dhbw.cleanproject.domain.book.Food;
import de.dhbw.cleanproject.domain.book.Fridge;

import java.time.LocalDate;
import java.util.Collections;

@SpringBootApplication
public class CleanProjectApplication {

    public static void main(String[] args) {
        //SpringApplication.run(CleanProjectApplication.class, args);
        SpringApplication app = new SpringApplication(CleanProjectApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);
    }

    @Bean
    public CommandLineRunner demo(ConsumerGoodsRepository repository) {
        return (args) -> {
        	repository.save(new ConsumerGoods(new Food("Tomate", new BestBeforeDate(1, 1, 2022)), new Quantity(), new Fridge("fridge")));
        	//repository.save(new ConsumerGoods("Banane"));
        	//repository.save(new ConsumerGood("Tomate", 1, "Bernard Cornwell", LocalDate.of(1996, 01, 01)));
        };
    }

}
