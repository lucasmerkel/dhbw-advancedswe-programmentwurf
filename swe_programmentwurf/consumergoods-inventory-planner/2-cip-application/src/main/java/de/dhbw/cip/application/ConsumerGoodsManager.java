package de.dhbw.cip.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.dhbw.cip.domain.ConsumerGoods;
import de.dhbw.cip.domain.ConsumerGoodsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumerGoodsManager {

    private ConsumerGoodsRepository consumerGoodsRepository;

    @Autowired
    public ConsumerGoodsManager(ConsumerGoodsRepository consumerGoodsRepository) {
        this.consumerGoodsRepository = consumerGoodsRepository;
    }

    public List<ConsumerGoods> findAllConsumerGoods() {
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
    
    public boolean updateConsumerGoodsWith(long eanCode, ConsumerGoods consumerGoods) {
    	if(this.consumerGoodsRepository.findStoredConsumerGoodsWith(eanCode).isEmpty()) return false;
    	try {
    		ConsumerGoods newConsumerGoods = this.consumerGoodsRepository.findStoredConsumerGoodsWith(eanCode).get();
    		newConsumerGoods.changeFood(consumerGoods.getFood());
    		//newConsumerGoods.changeUnitOfMeasure();
    		newConsumerGoods.changeStoragePlace(consumerGoods.getStorage());
    		//this.deleteConsumerGoods(id);
    		this.storeNew(newConsumerGoods);
			return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    public boolean storeNew(ConsumerGoods consumerGoods) {
    	try {
    		consumerGoodsRepository.storeNew(consumerGoods);
    		return true;
		} catch (Exception e) {
			return false;
		}
    }
}
