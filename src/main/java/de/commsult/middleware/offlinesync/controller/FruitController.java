package de.commsult.middleware.offlinesync.controller;

import de.commsult.middleware.offlinesync.entity.Fruit;
import de.commsult.middleware.offlinesync.service.FruitService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitController {

    private static final String CLASSNAME = FruitController.class.getSimpleName();

    private static final Logger logger = LoggerFactory.getLogger(FruitController.class);

    @Autowired
    FruitService fruitService;

    @GetMapping("/fruits")
    public List<Fruit> getAllFruits() {
        logger.info(CLASSNAME + ".getAllFruits() enter");
        
        return fruitService.getAllFruits();
    }
    
}
