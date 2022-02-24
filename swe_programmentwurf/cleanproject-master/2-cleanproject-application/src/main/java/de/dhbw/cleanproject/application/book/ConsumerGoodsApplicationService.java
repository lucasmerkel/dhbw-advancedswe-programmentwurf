package de.dhbw.cleanproject.application.book;

import de.dhbw.cleanproject.domain.book.ConsumerGoods;
import de.dhbw.cleanproject.domain.book.ConsumerGoodsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    
    public boolean deleteConsumerGoods(long id) {
    	try {
			consumerGoodsRepository.deleteConsumerGoods(id);
    		return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    public boolean updateConsumerGoods(long id, ConsumerGoods consumerGoods) {
    	if(consumerGoodsRepository.findConsumerGoods(id).isEmpty()) return false;
    	try {
    		ConsumerGoods newConsumerGoods = consumerGoodsRepository.findConsumerGoods(id).get();
    		newConsumerGoods.changeFoodDescription(consumerGoods.getFood().getDescription());
    		newConsumerGoods.changeFoodBestBeforedate(consumerGoods.getFood().getBbd());
    		newConsumerGoods.changeQuantity(consumerGoods.getQuantity());
    		newConsumerGoods.changeStoragePlace(consumerGoods.getStorage());
    		this.addConsumerGoods(newConsumerGoods);
			return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    public boolean addConsumerGoods(ConsumerGoods consumerGoods) {
    	try {
    		consumerGoodsRepository.save(consumerGoods);
    		return true;
		} catch (Exception e) {
			return false;
		}
    }
}
