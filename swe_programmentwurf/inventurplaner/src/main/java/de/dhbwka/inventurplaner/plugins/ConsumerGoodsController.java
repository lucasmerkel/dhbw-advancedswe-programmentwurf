package de.dhbwka.inventurplaner.plugins;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.dhbwka.inventurplaner.adapters.ConsumerGoodsRessource;
import de.dhbwka.inventurplaner.adapters.ConsumerGoodsToConsumerGoodsRessourceMapper;
import de.dhbwka.inventurplaner.adapters.FoodShelfToFoodShelfRessourceMapper;
import de.dhbwka.inventurplaner.adapters.FridgeToFridgeRessourceMapper;
import de.dhbwka.inventurplaner.application.ConsumerGoodsApplicationService;
import de.dhbwka.inventurplaner.application.FoodShelfApplicationService;
import de.dhbwka.inventurplaner.application.FridgeApplicationService;
import de.dhbwka.inventurplaner.domain.ConsumerGoods;

@RestController
@RequestMapping(value="/api/fridge")
public class ConsumerGoodsController {

	private ConsumerGoodsApplicationService consumerGoodsApplicationService;
	private FoodShelfApplicationService foodShelfApplicationService;
	private FridgeApplicationService fridgeApplicationService;
	
	private ConsumerGoodsToConsumerGoodsRessourceMapper cgRessourceMapper;
	private FoodShelfToFoodShelfRessourceMapper fsRessourceMapper;
	private FridgeToFridgeRessourceMapper fRessourceMapper;
	
	@Autowired
    public ConsumerGoodsController(ConsumerGoodsApplicationService consumerGoodsApplicationService, ConsumerGoodsToConsumerGoodsRessourceMapper cgRessourceMapper) {
        this.consumerGoodsApplicationService = consumerGoodsApplicationService;
        this.cgRessourceMapper = cgRessourceMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Object> getConsumerGoods() {
        return StreamSupport.stream(consumerGoodsApplicationService.findAllConsumerGoods().spliterator(), false)
                .map(cgRessourceMapper)
                .collect(Collectors.toList());
    }
}
