package de.dhbwka.inventurplaner.adapters;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import de.dhbwka.inventurplaner.domain.ConsumerGoods;

@Component
public class ConsumerGoodsToConsumerGoodsRessourceMapper implements Function<ConsumerGoods, ConsumerGoodsRessource> {

	//both methods for mapping domain class to ressource class
	public ConsumerGoodsRessource applyToRessource(ConsumerGoods goods) {
        return mapToRessource(goods);
    }

    private ConsumerGoodsRessource mapToRessource(ConsumerGoods goods) {
    	//TODO no new object, instead update Ressource object
    	return new ConsumerGoodsRessource(goods.getFood(), goods.getQuantity(), goods.getStorage());
    }
    
    //both methods for mapping ressource class to domain class
	public ConsumerGoods applyToDomain(ConsumerGoodsRessource goodsRessource) {
        return mapToDomain(goodsRessource);
    }

    private ConsumerGoods mapToDomain(ConsumerGoodsRessource goodsRessource) {
        return new ConsumerGoods(goodsRessource.getFood(), goodsRessource.getQuantity(), goodsRessource.getStorage());
    }

	public ConsumerGoodsRessource apply(ConsumerGoods t) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
