package de.dhbw.cleanproject.domain.book;

import java.util.List;
import java.util.Optional;

public interface ConsumerGoodsRepository {

    List<ConsumerGoods> findAllConsumerGoods();
    
    Optional<ConsumerGoods> findConsumerGoods(long id);
    
    boolean deleteConsumerGoods(long id);
    
    ConsumerGoods save(ConsumerGoods consumerGood);
}
