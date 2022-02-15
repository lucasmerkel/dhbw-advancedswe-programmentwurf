package de.dhbw.cleanproject.domain.book;

import java.util.List;

public interface ConsumerGoodsRepository {

    List<ConsumerGoods> findAllConsumerGoods();

    ConsumerGoods save(ConsumerGoods consumerGood);
}
