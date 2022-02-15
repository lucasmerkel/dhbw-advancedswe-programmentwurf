package de.dhbwka.inventurplaner.plugins;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.dhbwka.inventurplaner.domain.ConsumerGoods;
import de.dhbwka.inventurplaner.domain.ConsumerGoodsRepository;
	
@Repository
public class ConsumerGoodsRepositoryBridge implements ConsumerGoodsRepository {

	    private SpringDataConsumerGoodsRepository springDataConsumerGoodsRepository;

	    @Autowired
	    public ConsumerGoodsRepositoryBridge(SpringDataConsumerGoodsRepository springDataConsumerGoodsRepository) {
	        this.springDataConsumerGoodsRepository = springDataConsumerGoodsRepository;
	    }

		public Iterable<ConsumerGoods> getAllConsumerGoods() {
			 return this.springDataConsumerGoodsRepository.findAll();
		}

		public ConsumerGoods save(ConsumerGoods goods) {
			return this.springDataConsumerGoodsRepository.save(goods);
		}
}
