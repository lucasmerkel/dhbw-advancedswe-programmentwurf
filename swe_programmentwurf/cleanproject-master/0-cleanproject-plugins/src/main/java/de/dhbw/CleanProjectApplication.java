package de.dhbw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import de.dhbw.cleanproject.abstractioncode.consumergoods.Quantity;
import de.dhbw.cleanproject.book.ConsumerGoodsResource;
import de.dhbw.cleanproject.domain.book.BestBeforeDate;
import de.dhbw.cleanproject.domain.book.ConsumerGoods;
import de.dhbw.cleanproject.domain.book.ConsumerGoodsRepository;
import de.dhbw.cleanproject.domain.book.Food;
import de.dhbw.cleanproject.domain.book.FoodShelf;
import de.dhbw.cleanproject.domain.book.Fridge;

import java.time.LocalDate;
import java.util.Arrays;
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
        	repository.save(new ConsumerGoods(new Food("Tomatoe", new BestBeforeDate(1, 1, 2022)), new Quantity(3), new Fridge("fridge")));
        	repository.save(new ConsumerGoods(new Food("Banana", new BestBeforeDate(1, 1, 2022)), new Quantity(5), new FoodShelf("foodshelf")));
        	//repository.save(new ConsumerGoods("Banane"));
        	//repository.save(new ConsumerGood("Tomate", 1, "Bernard Cornwell", LocalDate.of(1996, 01, 01)));
        };
    }
    
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
	
}
