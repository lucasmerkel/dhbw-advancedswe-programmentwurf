package de.dhbw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.dhbw.cleanproject.domain.book.ConsumerGoods;
import de.dhbw.cleanproject.domain.book.ConsumerGoodsRepository;

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
        	repository.save(new ConsumerGoods("Tomate"));
        	//repository.save(new ConsumerGood("Tomate", 1, "Bernard Cornwell", LocalDate.of(1996, 01, 01)));
        };
    }

}
