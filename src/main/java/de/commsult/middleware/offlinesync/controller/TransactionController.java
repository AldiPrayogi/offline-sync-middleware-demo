package de.commsult.middleware.offlinesync.controller;

import de.commsult.middleware.offlinesync.entity.Fruit;
import de.commsult.middleware.offlinesync.entity.Transaction;
import de.commsult.middleware.offlinesync.service.TransactionService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    private static final String CLASSNAME = TransactionController.class.getSimpleName();

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    TransactionService transactionService;
    
    @PostMapping("/transactions/post")
    public List<Fruit> postTransactions(@RequestBody List<Transaction> transactions) {
        logger.info(CLASSNAME + ".postTransactions() enter");
        
        return transactionService.insertAllTransactions(transactions);
    }
    
    @GetMapping("/transactions")
    public List<Transaction> postTransactions() {
        logger.info(CLASSNAME + ".postTransactions() enter");
        
        return transactionService.getAllTransactions();
    }
    
}
