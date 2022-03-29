package de.dhbw.cip.domain;

import java.util.List;
import java.util.Optional;

public interface ConsumerGoodsRepository {

    List<ConsumerGoods> findAllStoredConsumerGoods();
    
    Optional<ConsumerGoods> findStoredConsumerGoods(long id);
    
    boolean outsourceConsumerGoods(long id);
    
    ConsumerGoods storeNewConsumerGoods(ConsumerGoods consumerGood);
}
