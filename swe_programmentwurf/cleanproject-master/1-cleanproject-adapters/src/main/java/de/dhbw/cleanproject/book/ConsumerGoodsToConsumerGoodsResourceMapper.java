package de.dhbw.cleanproject.book;

import org.springframework.stereotype.Component;

import de.dhbw.cleanproject.domain.book.ConsumerGoods;

import java.util.function.Function;

@Component
public class ConsumerGoodsToConsumerGoodsResourceMapper implements Function<ConsumerGoods, ConsumerGoodsResource> {

    @Override
    public ConsumerGoodsResource apply(ConsumerGoods consumerGoods) {
        return map(consumerGoods);
    }

    private ConsumerGoodsResource map(ConsumerGoods consumerGoods) {
        return new ConsumerGoodsResource(consumerGoods.getTitle());
    }
}
