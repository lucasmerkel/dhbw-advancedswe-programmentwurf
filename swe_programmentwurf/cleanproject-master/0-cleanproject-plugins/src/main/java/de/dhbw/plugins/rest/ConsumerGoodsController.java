package de.dhbw.plugins.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.dhbw.cleanproject.abstractioncode.consumergoods.Volume;
import de.dhbw.cleanproject.application.book.ConsumerGoodsApplicationService;
import de.dhbw.cleanproject.book.ConsumerGoodsResource;
import de.dhbw.cleanproject.book.ConsumerGoodsToConsumerGoodsResourceMapper;
import de.dhbw.cleanproject.domain.book.BestBeforeDate;
import de.dhbw.cleanproject.domain.book.ConsumerGoods;
import de.dhbw.cleanproject.domain.book.Food;
import de.dhbw.cleanproject.domain.book.Fridge;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/consumergoods")
public class ConsumerGoodsController {

    private ConsumerGoodsApplicationService consumerGoodsApplicationService;

    private ConsumerGoodsToConsumerGoodsResourceMapper consumerGoodsToConsumerGoodsResourceMapper;

    @Autowired
    public ConsumerGoodsController(ConsumerGoodsApplicationService consumerGoodsApplicationService, 
    		ConsumerGoodsToConsumerGoodsResourceMapper consumerGoodsToConsumerGoodsResourceMapper) {
        this.consumerGoodsApplicationService = consumerGoodsApplicationService;
        this.consumerGoodsToConsumerGoodsResourceMapper = consumerGoodsToConsumerGoodsResourceMapper;
    }

    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    public List<ConsumerGoodsResource> getConsumerGoods() {
        return this.consumerGoodsApplicationService.findAllConsumerGoods().stream()
                .map(consumerGoodsToConsumerGoodsResourceMapper)
                .collect(Collectors.toList());
    }

    //POST
    //Update Repository and ApplicationService
    //@RequestMapping(value="/{description}%{bestbeforedateday}%{bestbeforedatemonth}%{bestbeforedateyear}%{quantityvalue}%{quantity}%{storage}", method = RequestMethod.POST)
    @RequestMapping(value="/add" ,method = RequestMethod.POST)
    @ResponseBody
    public String postConsumerGood(@RequestParam("description") String description, @RequestParam("bestbeforedateday") int bestBeforeDateDay,
    		@RequestParam("bestbeforedatemonth") int bestBeforeDateMonth, @RequestParam("bestbeforedateyear") int bestBeforeDateYear, 
    		@RequestParam("quantityvalue") double quantityValue, @RequestParam("quantity") String quantity, @RequestParam("storage") String storage) {
    		//@PathVariable("bestbeforedateday") int bestBeforeDateDay, @PathVariable("bestbeforedatemonth") int bestBeforeDateMonth,
    		//@PathVariable("bestbeforedateyear") int bestBeforeDateYear, @PathVariable("quantityvalue") double quantityValue, 
    		//@PathVariable("quantity") String quantity, @PathVariable("storage") String storage) {
        		//return "Result: "+description+", "+bestBeforeDateDay+"."+bestBeforeDateMonth+"."+bestBeforeDateYear+"; "
        			//	+quantityValue+quantity+"; "+storage;
    	
    	//classes or values as parameters
    	//send error if something goes wrong
    	consumerGoodsApplicationService.addConsumerGoods(new ConsumerGoods(new Food(description, new BestBeforeDate(bestBeforeDateDay, bestBeforeDateMonth, bestBeforeDateYear)), new Volume(quantityValue), new Fridge("fridge")));
    	
    	System.out.println("Result: "+description+", "+bestBeforeDateDay+"."+bestBeforeDateMonth+"."+bestBeforeDateYear+"; "
    				+quantityValue+quantity+"; "+storage);	
    	return "Result: "+description+", "+bestBeforeDateDay+"."+bestBeforeDateMonth+"."+bestBeforeDateYear+"; "
    				+quantityValue+quantity+"; "+storage;
    }

    //DELETE
    //Update Repository and ApplicationService
    @RequestMapping(value="/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteConsumerGood(@RequestParam(name = "id") long id) {
    	
    	//send error if something goes wrong
    	consumerGoodsApplicationService.deleteConsumerGoods(id);
    	System.out.println("Delete item with id:"+String.valueOf(id));
        return "Delete item with id:"+String.valueOf(id);
    }
    //PATCH
    //Update Repository and ApplicationService
    //Alternative is DELETE and POST    
    @RequestMapping(value="/update", method = RequestMethod.PUT)
    @ResponseBody
    public String updateConsumerGood(@RequestParam("id") long id, @RequestParam("description") String description, @RequestParam("bestbeforedateday") int bestBeforeDateDay,
    		@RequestParam("bestbeforedatemonth") int bestBeforeDateMonth, @RequestParam("bestbeforedateyear") int bestBeforeDateYear, 
    		@RequestParam("quantityvalue") double quantityValue, @RequestParam("quantity") String quantity, @RequestParam("storage") String storage) {
    	
    	//new class for values or direct values
    	//send error if something goes wrong
    	boolean test = consumerGoodsApplicationService.updateConsumerGoods(id, new ConsumerGoods(new Food(description, new BestBeforeDate(bestBeforeDateDay, bestBeforeDateMonth, bestBeforeDateYear)), new Volume(quantityValue), new Fridge("fridge")));
    	System.out.println(test);
    	
    	System.out.println("Result: "+id+","+description+", "+bestBeforeDateDay+"."+bestBeforeDateMonth+"."+bestBeforeDateYear+"; "
    				+quantityValue+quantity+"; "+storage);
    	return "Result: "+description+", "+bestBeforeDateDay+"."+bestBeforeDateMonth+"."+bestBeforeDateYear+"; "
    				+quantityValue+quantity+"; "+storage;
    }
}
