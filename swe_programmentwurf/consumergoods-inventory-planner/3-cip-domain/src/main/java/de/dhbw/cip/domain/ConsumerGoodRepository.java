package de.dhbw.cip.domain;

import java.util.Optional;

public interface ConsumerGoodRepository {

    Iterable<ConsumerGood> findAllStoredConsumerGoods();
    
    Optional<ConsumerGood> findStoredConsumerGoodsWith(long eanCode);
    
    boolean outsourceConsumerGoodsWith(long eanCode);
    
    ConsumerGood storeNew(ConsumerGood consumerGood);
}
