package de.dhbw.cip.plugins.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import de.dhbw.cip.adapters.ConsumerGoodsResource;
import de.dhbw.cip.adapters.ConsumerGoodsToConsumerGoodsResourceMapper;
import de.dhbw.cip.application.ConsumerGoodsManager;
import de.dhbw.cip.domain.ConsumerGoods.ConsumerGoodsBuilder;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(value = "/api/consumergoods")
public class ConsumerGoodsGuiController {

    private ConsumerGoodsManager consumerGoodsApplicationService;
    private ConsumerGoodsToConsumerGoodsResourceMapper consumerGoodsToConsumerGoodsResourceMapper;
    
    @Autowired
    public ConsumerGoodsGuiController(ConsumerGoodsManager consumerGoodsApplicationService, 
    		ConsumerGoodsToConsumerGoodsResourceMapper consumerGoodsToConsumerGoodsResourceMapper) {
        this.consumerGoodsApplicationService = consumerGoodsApplicationService;
        this.consumerGoodsToConsumerGoodsResourceMapper = consumerGoodsToConsumerGoodsResourceMapper;
    }

    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    public Iterable<ConsumerGoodsResource> getConsumerGoods() {
    	return StreamSupport.stream(this.consumerGoodsApplicationService.findAllConsumerGoods().spliterator(), false)
    			.map(consumerGoodsToConsumerGoodsResourceMapper)
    			.collect(Collectors.toList());
    }

    @RequestMapping(value="/add" ,method = RequestMethod.POST)
    public HttpStatus postConsumerGood(@RequestParam("eancode") long eanCode, @RequestParam("description") String description, @RequestParam("bestbeforedateday") int bestBeforeDateDay,
    		@RequestParam("bestbeforedatemonth") int bestBeforeDateMonth, @RequestParam("bestbeforedateyear") int bestBeforeDateYear, 
    		@RequestParam("quantityvalue") int quantityValue, @RequestParam("quantity") String quantity, @RequestParam("storage") String storage, @RequestParam("storagetype") String storageType) {
    	//Parameters for DTO
    	//HttpServletRequest request, @RequestBody ConsumerGoodsResource consumerGoodsResource

    	
    	ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder(eanCode, description, bestBeforeDateDay, bestBeforeDateMonth, bestBeforeDateYear, quantity, quantityValue, storageType, storage);
    	System.out.println(consumerGoodsBuilder.validate());
    	if(consumerGoodsBuilder.validate() && consumerGoodsApplicationService.storeNew(eanCode, consumerGoodsBuilder.build())) return HttpStatus.OK;
    	//return HttpStatus.INTERNAL_SERVER_ERROR;
    	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error while add new consumer goods");
    }

    @RequestMapping(value="/delete", method = RequestMethod.DELETE)
    public HttpStatus deleteConsumerGood(@RequestParam(name = "eancode") long eanCode) {
    	if(consumerGoodsApplicationService.outsourceConsumerGoodsWith(eanCode)) return HttpStatus.OK;
    	//return HttpStatus.NOT_FOUND;
    	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error while delete consumer goods");
    }

    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public HttpStatus updateConsumerGood(@RequestParam("eancode") long eanCode, @RequestParam("description") String description, @RequestParam("bestbeforedateday") int bestBeforeDateDay,
    		@RequestParam("bestbeforedatemonth") int bestBeforeDateMonth, @RequestParam("bestbeforedateyear") int bestBeforeDateYear, 
    		@RequestParam("quantityvalue") int quantityValue, @RequestParam("quantity") String quantity, @RequestParam("storage") String storage, @RequestParam("storagetype") String storageType) {

    	ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder(eanCode, description, bestBeforeDateDay, bestBeforeDateMonth, bestBeforeDateYear, quantity, quantityValue, storageType, storage);
    	System.out.println(consumerGoodsBuilder.validate());
    	if(consumerGoodsBuilder.validate() && consumerGoodsApplicationService.updateConsumerGoodsWith(eanCode, consumerGoodsBuilder.build())) return HttpStatus.OK;
    	//return HttpStatus.INTERNAL_SERVER_ERROR;
    	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error while update consumer goods");
    }
}
