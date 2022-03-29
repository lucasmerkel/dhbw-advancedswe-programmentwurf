package de.dhbw.cip.plugins.persistence.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.dhbw.cip.domain.ConsumerGoods;
import de.dhbw.cip.domain.ConsumerGoodsRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ConsumerGoodsRepositoryBridge implements ConsumerGoodsRepository {

    private PersistenceConsumerGoodsRepository springDataConsumerGoodsRepository;

    @Autowired
    public ConsumerGoodsRepositoryBridge(PersistenceConsumerGoodsRepository springDataConsumerGoodsRepository) {
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
