package de.dhbwka.inventurplaner.domain;

public interface ConsumerGoodsRepository {

	public Iterable<ConsumerGoods> getAllConsumerGoods();
	
	public ConsumerGoods save(ConsumerGoods goods);
}
