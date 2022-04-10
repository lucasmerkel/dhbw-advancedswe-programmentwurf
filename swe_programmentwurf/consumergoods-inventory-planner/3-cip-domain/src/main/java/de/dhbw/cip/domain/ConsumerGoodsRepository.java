package de.dhbw.cip.domain;

import java.util.List;
import java.util.Optional;

public interface ConsumerGoodsRepository {

    Iterable<ConsumerGoods> findAllStoredConsumerGoods();
    
    Optional<ConsumerGoods> findStoredConsumerGoodsWith(long eanCode);
    
    boolean outsourceConsumerGoodsWith(long eanCode);
    
    ConsumerGoods storeNew(ConsumerGoods consumerGood);
}
