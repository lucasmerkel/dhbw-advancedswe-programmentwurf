package de.dhbw.cleanproject.application.book;

import de.dhbw.cleanproject.domain.book.ConsumerGoods;
import de.dhbw.cleanproject.domain.book.ConsumerGoodsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerGoodsApplicationService {

    private ConsumerGoodsRepository consumerGoodsRepository;

    @Autowired
    public ConsumerGoodsApplicationService(ConsumerGoodsRepository consumerGoodsRepository) {
        this.consumerGoodsRepository = consumerGoodsRepository;
    }

    public List<ConsumerGoods> findAllConsumerGoods() {
        return this.consumerGoodsRepository.findAllConsumerGoods();
    }
}
