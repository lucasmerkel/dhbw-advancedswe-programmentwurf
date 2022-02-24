package de.dhbw.plugins.persistence.hibernate.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.dhbw.cleanproject.book.ConsumerGoodsResource;
import de.dhbw.cleanproject.domain.book.ConsumerGoods;
import de.dhbw.cleanproject.domain.book.ConsumerGoodsRepository;

import java.util.List;
import java.util.Optional;

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
	public ConsumerGoods save(ConsumerGoods consumerGood) {
		return this.springDataConsumerGoodsRepository.save(consumerGood);
	}

	@Override
	public Optional<ConsumerGoods> findConsumerGoods(long id) {
		return this.springDataConsumerGoodsRepository.findById(id);
	}

	@Override
	public boolean deleteConsumerGoods(long id) {
		try {
			this.springDataConsumerGoodsRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
