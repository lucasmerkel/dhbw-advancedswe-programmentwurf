package de.dhbw.cip;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import de.dhbw.cip.abstractioncode.DayOfYear;
import de.dhbw.cip.abstractioncode.Month;
import de.dhbw.cip.abstractioncode.Day;
import de.dhbw.cip.abstractioncode.Quantity;
import de.dhbw.cip.abstractioncode.Year;
import de.dhbw.cip.domain.BestBeforeDate;
import de.dhbw.cip.domain.ConsumerGoods;
import de.dhbw.cip.domain.ConsumerGoods.ConsumerGoodsBuilder;
import de.dhbw.cip.domain.ConsumerGoodsRepository;
import de.dhbw.cip.domain.Food;
import de.dhbw.cip.domain.FoodShelf;
import de.dhbw.cip.domain.Fridge;
import de.dhbw.cip.abstractioncode.Value;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class ConsumerInventoryPlannerApplication {

    public static void main(String[] args) {
        //SpringApplication.run(CleanProjectApplication.class, args);
        SpringApplication app = new SpringApplication(ConsumerInventoryPlannerApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);
    }

    @Bean
    public CommandLineRunner demo(ConsumerGoodsRepository repository) {
        return (args) -> {
        	repository.storeNewConsumerGoods(new ConsumerGoodsBuilder("Tomatoe", 1, 1, 2022, "Stk.", 3, "Fridge", "fridge in the kitchen").build());
        	repository.storeNewConsumerGoods(new ConsumerGoodsBuilder("Banana", 2, 3, 2022, "Stk.", 5, "FoodShelf", "foodshelf in the basement").build());
        	//repository.save(new ConsumerGoods(new Food("Tomatoe", new BestBeforeDate( new DayOfYear(new Day(1), new Month(1)), new Year(2022))), new Quantity(new Value(3)), new Fridge("fridge")));
        	//repository.save(new ConsumerGoods(new Food("Banana", new BestBeforeDate( new DayOfYear(new Day(1), new Month(1)), new Year(2022))), new Quantity(new Value(5)), new FoodShelf("foodshelf")));
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
