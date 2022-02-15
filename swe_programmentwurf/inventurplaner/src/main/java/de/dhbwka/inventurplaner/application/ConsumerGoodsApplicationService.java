package de.dhbwka.inventurplaner.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.dhbwka.inventurplaner.adapters.FoodRessource;
import de.dhbwka.inventurplaner.domain.ConsumerGoods;
import de.dhbwka.inventurplaner.domain.ConsumerGoodsRepository;

@Service
public class ConsumerGoodsApplicationService {

	private ConsumerGoodsRepository consumerGoodsRepository;

    @Autowired
    public ConsumerGoodsApplicationService(ConsumerGoodsRepository consumerGoodsRepository) {
        this.consumerGoodsRepository = consumerGoodsRepository;
    }

    //Iterable<ConsumerGoods>
    public Iterable<ConsumerGoods> findAllConsumerGoods() {
        return this.consumerGoodsRepository.getAllConsumerGoods();
    }
}
