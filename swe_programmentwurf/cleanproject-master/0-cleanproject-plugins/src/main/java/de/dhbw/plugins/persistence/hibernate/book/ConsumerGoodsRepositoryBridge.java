package de.dhbw.plugins.persistence.hibernate.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.dhbw.cleanproject.domain.book.ConsumerGoods;
import de.dhbw.cleanproject.domain.book.ConsumerGoodsRepository;

import java.util.List;

@Repository
public class ConsumerGoodsRepositoryBridge implements ConsumerGoodsRepository {

    private SpringDataConsumerGoodsRepository springDataConsumerGoodsRepository;

    @Autowired
    public ConsumerGoodsRepositoryBridge(SpringDataConsumerGoodsRepository springDataConsumerGoodsRepository) {
        this.springDataConsumerGoodsRepository = springDataConsumerGoodsRepository;
    }

    @Override
    public List<ConsumerGoods> findAllConsumerGoods() {
        return this.springDataConsumerGoodsRepository.findAll();
    }

    @Override
    public ConsumerGoods save(ConsumerGoods consumerGoods) {
        return this.springDataConsumerGoodsRepository.save(consumerGoods);
    }

}
