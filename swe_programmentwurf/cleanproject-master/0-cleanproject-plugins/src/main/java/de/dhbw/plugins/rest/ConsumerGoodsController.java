package de.dhbw.plugins.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.dhbw.cleanproject.application.book.ConsumerGoodsApplicationService;
import de.dhbw.cleanproject.book.ConsumerGoodsResource;
import de.dhbw.cleanproject.book.ConsumerGoodsToConsumerGoodsResourceMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/fridge")
public class ConsumerGoodsController {

    private ConsumerGoodsApplicationService consumerGoodsApplicationService;

    private ConsumerGoodsToConsumerGoodsResourceMapper consumerGoodsToConsumerGoodsResourceMapper;

    @Autowired
    public ConsumerGoodsController(ConsumerGoodsApplicationService consumerGoodsApplicationService, 
    		ConsumerGoodsToConsumerGoodsResourceMapper consumerGoodsToConsumerGoodsResourceMapper) {
        this.consumerGoodsApplicationService = consumerGoodsApplicationService;
        this.consumerGoodsToConsumerGoodsResourceMapper = consumerGoodsToConsumerGoodsResourceMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ConsumerGoodsResource> getConsumerGoods() {
        return this.consumerGoodsApplicationService.findAllConsumerGoods().stream()
                .map(consumerGoodsToConsumerGoodsResourceMapper)
                .collect(Collectors.toList());
    }
}
