package de.dhbw.cip.plugins.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import de.dhbw.cip.abstractioncode.Day;
import de.dhbw.cip.abstractioncode.DayOfYear;
import de.dhbw.cip.abstractioncode.Month;
import de.dhbw.cip.abstractioncode.Value;
import de.dhbw.cip.abstractioncode.Volume;
import de.dhbw.cip.abstractioncode.Year;
import de.dhbw.cip.adapters.ConsumerGoodsResource;
import de.dhbw.cip.adapters.ConsumerGoodsToConsumerGoodsResourceMapper;
import de.dhbw.cip.application.ConsumerGoodsManager;
import de.dhbw.cip.application.StorageManager;
import de.dhbw.cip.domain.BestBeforeDate;
import de.dhbw.cip.domain.ConsumerGoods;
import de.dhbw.cip.domain.ConsumerGoods.ConsumerGoodsBuilder;
import de.dhbw.cip.domain.ConsumerGoodsRepository;
import de.dhbw.cip.domain.Food;
import de.dhbw.cip.domain.Fridge;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/consumergoods")
public class ConsumerGoodsGuiController {

    private ConsumerGoodsManager consumerGoodsApplicationService;
    private ConsumerGoodsToConsumerGoodsResourceMapper consumerGoodsToConsumerGoodsResourceMapper;
    private ConsumerGoodsRepository consumerGoodsRepository;
    
    @Autowired
    public ConsumerGoodsGuiController(ConsumerGoodsManager consumerGoodsApplicationService, 
    		ConsumerGoodsToConsumerGoodsResourceMapper consumerGoodsToConsumerGoodsResourceMapper,
    		ConsumerGoodsRepository consumerGoodsRepository) {
        this.consumerGoodsApplicationService = consumerGoodsApplicationService;
        this.consumerGoodsToConsumerGoodsResourceMapper = consumerGoodsToConsumerGoodsResourceMapper;
        this.consumerGoodsRepository = consumerGoodsRepository;
    }

    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    public Iterable<ConsumerGoodsResource> getConsumerGoods() {
    	return StreamSupport.stream(this.consumerGoodsApplicationService.findAllConsumerGoods().spliterator(), false)
    			.map(consumerGoodsToConsumerGoodsResourceMapper)
    			.collect(Collectors.toList());
        //return this.consumerGoodsApplicationService.findAllConsumerGoods().stream()
          //      .map(consumerGoodsToConsumerGoodsResourceMapper)
            //    .collect(Collectors.toList());
    }

    @RequestMapping(value="/add" ,method = RequestMethod.POST)
    //@ResponseBody
    public HttpStatus postConsumerGood(@RequestParam("eancode") long eanCode, @RequestParam("description") String description, @RequestParam("bestbeforedateday") int bestBeforeDateDay,
    		@RequestParam("bestbeforedatemonth") int bestBeforeDateMonth, @RequestParam("bestbeforedateyear") int bestBeforeDateYear, 
    		@RequestParam("quantityvalue") int quantityValue, @RequestParam("quantity") String quantity, @RequestParam("storage") String storage, @RequestParam("storagetype") String storageType) {
    	//Parameters for DTO
    	//HttpServletRequest request, @RequestBody ConsumerGoodsResource consumerGoodsResource

    	
    	ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder(this.consumerGoodsRepository, eanCode, description, bestBeforeDateDay, bestBeforeDateMonth, bestBeforeDateYear, quantity, quantityValue, storageType, storage);
    	System.out.println(consumerGoodsBuilder.validate());
    	if(consumerGoodsBuilder.validate() && consumerGoodsApplicationService.storeNew(eanCode, consumerGoodsBuilder.build())) return HttpStatus.OK;
    	//return HttpStatus.INTERNAL_SERVER_ERROR;
    	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error while add new consumer goods");
    	
    	//consumerGoodsApplicationService.addConsumerGoods(new ConsumerGoods(new Food(description, new BestBeforeDate( new DayOfYear(new Day(bestBeforeDateDay), new Month(bestBeforeDateMonth)), new Year(bestBeforeDateYear))), new Volume(new Value(quantityValue)), new Fridge("fridge")));
    	//System.out.println("Result: "+description+", "+bestBeforeDateDay+"."+bestBeforeDateMonth+"."+bestBeforeDateYear+"; "
    	//			+quantityValue+quantity+"; "+storage);	
    	//return "Result: "+description+", "+bestBeforeDateDay+"."+bestBeforeDateMonth+"."+bestBeforeDateYear+"; "
    	//			+quantityValue+quantity+"; "+storage;
    }

    @RequestMapping(value="/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public HttpStatus deleteConsumerGood(@RequestParam(name = "eancode") long eanCode) {
    	//send error if something goes wrong
    	if(consumerGoodsApplicationService.outsourceConsumerGoodsWith(eanCode)) return HttpStatus.OK;
    	//return HttpStatus.NOT_FOUND;
    	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error while delete consumer goods");
    }

    @RequestMapping(value="/update", method = RequestMethod.PUT)
    @ResponseBody
    public HttpStatus updateConsumerGood(@RequestParam("eancode") long eanCode, @RequestParam("description") String description, @RequestParam("bestbeforedateday") int bestBeforeDateDay,
    		@RequestParam("bestbeforedatemonth") int bestBeforeDateMonth, @RequestParam("bestbeforedateyear") int bestBeforeDateYear, 
    		@RequestParam("quantityvalue") int quantityValue, @RequestParam("quantity") String quantity, @RequestParam("storage") String storage, @RequestParam("storagetype") String storageType) {

    	ConsumerGoodsBuilder consumerGoodsBuilder = new ConsumerGoodsBuilder(this.consumerGoodsRepository, eanCode, description, bestBeforeDateDay, bestBeforeDateMonth, bestBeforeDateYear, quantity, quantityValue, storageType, storage);
    	System.out.println(consumerGoodsBuilder.validate());
    	if(consumerGoodsBuilder.validate() && consumerGoodsApplicationService.updateConsumerGoodsWith(eanCode, consumerGoodsBuilder.build())) return HttpStatus.OK;
    	//return HttpStatus.INTERNAL_SERVER_ERROR;
    	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error while update consumer goods");
    	
    	//boolean test = consumerGoodsApplicationService.updateConsumerGoods(id, new ConsumerGoods(new Food(description, new BestBeforeDate( new DayOfYear(new Day(bestBeforeDateDay), new Month(bestBeforeDateMonth)), new Year(bestBeforeDateYear))), new Volume(new Value(quantityValue)), new Fridge("fridge")));
    	//System.out.println(test);
    	//System.out.println("Result: "+eanCode+","+description+", "+bestBeforeDateDay+"."+bestBeforeDateMonth+"."+bestBeforeDateYear+"; "
    	//			+quantityValue+quantity+"; "+storage);
    	//return "Result: "+description+", "+bestBeforeDateDay+"."+bestBeforeDateMonth+"."+bestBeforeDateYear+"; "
    	//			+quantityValue+quantity+"; "+storage;
    }
}
