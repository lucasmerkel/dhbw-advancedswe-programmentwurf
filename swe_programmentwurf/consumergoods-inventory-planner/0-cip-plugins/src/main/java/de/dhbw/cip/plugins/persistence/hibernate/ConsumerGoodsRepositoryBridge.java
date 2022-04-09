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
    public List<ConsumerGoods> findAllStoredConsumerGoods() {
        return this.springDataConsumerGoodsRepository.findAll();
    }

	@Override
	public ConsumerGoods storeNew(ConsumerGoods ConsumerGood) {
		return this.springDataConsumerGoodsRepository.save(ConsumerGood);
	}

	@Override
	public Optional<ConsumerGoods> findStoredConsumerGoodsWith(long eanCode) {
		return this.springDataConsumerGoodsRepository.findById(eanCode);
	}

	@Override
	public boolean outsourceConsumerGoodsWith(long eanCode) {
		try {
			this.springDataConsumerGoodsRepository.deleteById(eanCode);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
