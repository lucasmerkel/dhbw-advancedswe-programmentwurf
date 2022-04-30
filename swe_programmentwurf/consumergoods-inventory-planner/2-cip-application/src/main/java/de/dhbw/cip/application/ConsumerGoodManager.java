package de.dhbw.cip.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.dhbw.cip.domain.ConsumerGood;
import de.dhbw.cip.domain.ConsumerGoodRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumerGoodManager {

    private ConsumerGoodRepository consumerGoodsRepository;

    @Autowired
    public ConsumerGoodManager(ConsumerGoodRepository consumerGoodsRepository) {
        this.consumerGoodsRepository = consumerGoodsRepository;
    }

    public Iterable<ConsumerGood> findAllConsumerGoods() {
        return this.consumerGoodsRepository.findAllStoredConsumerGoods();
    }
    
    public boolean outsourceConsumerGoodsWith(long eanCode) {
    	try {
    		if(this.consumerGoodsRepository.findStoredConsumerGoodsWith(eanCode).isEmpty()) return false;
			this.consumerGoodsRepository.outsourceConsumerGoodsWith(eanCode);
    		return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    public boolean updateConsumerGoodsWith(long eanCode, ConsumerGood consumerGoods) {
    	if(this.consumerGoodsRepository.findStoredConsumerGoodsWith(eanCode).isEmpty()) return false;
    	try {
    		ConsumerGood newConsumerGoods = this.consumerGoodsRepository.findStoredConsumerGoodsWith(eanCode).get();
    		newConsumerGoods.changeFood(consumerGoods.getFood());
    		newConsumerGoods.changeUnitOfMeasure(consumerGoods.getQuantity());
    		newConsumerGoods.changeStoragePlace(consumerGoods.getStorage());
    		
    		this.outsourceConsumerGoodsWith(eanCode);
    		this.storeNew(eanCode, newConsumerGoods);
    		
			return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    public boolean storeNew(long eanCode, ConsumerGood consumerGoods) {
    	try {
    		if(!this.consumerGoodsRepository.findStoredConsumerGoodsWith(eanCode).isEmpty()) return false;
    		consumerGoodsRepository.storeNew(consumerGoods);
    		return true;
		} catch (Exception e) {
			return false;
		}
    }
}
