package de.dhbwka.inventurplaner.application;

import org.springframework.beans.factory.annotation.Autowired;

import de.dhbwka.inventurplaner.adapters.FoodRessource;
import de.dhbwka.inventurplaner.domain.ConsumerGoods;
import de.dhbwka.inventurplaner.domain.ConsumerGoodsRepository;

public class ConsumerGoodsApplicationService {

	private ConsumerGoodsRepository consumerGoodsRepository;

    @Autowired
    public ConsumerGoodsApplicationService(ConsumerGoodsRepository consumerGoodsRepository) {
        this.consumerGoodsRepository = consumerGoodsRepository;
    }

    public Iterable<ConsumerGoods> findAllConsumerGoods() {
        return this.consumerGoodsRepository.getAllConsumerGoods();
    }
}
