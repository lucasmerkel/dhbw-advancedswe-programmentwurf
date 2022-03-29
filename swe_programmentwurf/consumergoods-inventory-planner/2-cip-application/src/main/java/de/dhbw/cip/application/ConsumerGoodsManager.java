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
    
    public boolean deleteConsumerGoods(long id) {
    	try {
			consumerGoodsRepository.outsourceConsumerGoods(id);
    		return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    public boolean updateConsumerGoods(long id, ConsumerGoods consumerGoods) {
    	if(consumerGoodsRepository.findStoredConsumerGoods(id).isEmpty()) return false;
    	try {
    		ConsumerGoods newConsumerGoods = consumerGoodsRepository.findStoredConsumerGoods(id).get();
    		newConsumerGoods.changeFood(consumerGoods.getFood());
    		newConsumerGoods.changeStoragePlace(consumerGoods.getStorage());
    		this.addConsumerGoods(newConsumerGoods);
			return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    public boolean addConsumerGoods(ConsumerGoods consumerGoods) {
    	try {
    		consumerGoodsRepository.storeNewConsumerGoods(consumerGoods);
    		return true;
		} catch (Exception e) {
			return false;
		}
    }
}
