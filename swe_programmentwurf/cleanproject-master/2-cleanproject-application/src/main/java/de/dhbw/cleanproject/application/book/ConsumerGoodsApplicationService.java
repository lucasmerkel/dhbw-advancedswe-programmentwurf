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
    
    public boolean deleteConsumerGoods(long id) {
    	try {
			
    		return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    public boolean updateConsumerGoods(long id, ConsumerGoods consumerGoods) {
    	try {
			
    		return true;
		} catch (Exception e) {
			return false;
		}
    }
    
    public boolean addConsumerGoods(ConsumerGoods consumerGoods) {
    	try {
			
    		return true;
		} catch (Exception e) {
			return false;
		}
    }
}
