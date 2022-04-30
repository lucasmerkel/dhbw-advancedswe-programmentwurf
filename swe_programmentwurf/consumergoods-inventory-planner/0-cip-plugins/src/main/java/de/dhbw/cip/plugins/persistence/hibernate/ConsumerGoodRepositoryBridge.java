package de.dhbw.cip.plugins.persistence.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import de.dhbw.cip.domain.ConsumerGood;
import de.dhbw.cip.domain.ConsumerGoodRepository;

import java.util.Optional;

@Repository
public class ConsumerGoodRepositoryBridge implements ConsumerGoodRepository {

    private PersistenceConsumerGoodRepository springDataConsumerGoodsRepository;

    @Autowired
    public ConsumerGoodRepositoryBridge(PersistenceConsumerGoodRepository springDataConsumerGoodsRepository) {
        this.springDataConsumerGoodsRepository = springDataConsumerGoodsRepository;
    }

    @Override
    public Iterable<ConsumerGood> findAllStoredConsumerGoods() {
        return this.springDataConsumerGoodsRepository.findAll();
    }

	@Override
	public ConsumerGood storeNew(ConsumerGood ConsumerGood) {
		return this.springDataConsumerGoodsRepository.save(ConsumerGood);
	}

	@Override
	public Optional<ConsumerGood> findStoredConsumerGoodsWith(long eanCode) {
		return this.springDataConsumerGoodsRepository.findById(eanCode);
	}

	@Override
	public boolean outsourceConsumerGoodsWith(long eanCode) {
		try {
			this.springDataConsumerGoodsRepository.deleteById(eanCode);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
