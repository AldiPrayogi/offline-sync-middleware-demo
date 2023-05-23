package de.commsult.middleware.offlinesync.service;

import de.commsult.middleware.offlinesync.entity.Fruit;
import de.commsult.middleware.offlinesync.entity.Transaction;
import de.commsult.middleware.offlinesync.enums.TransactionStatus;
import de.commsult.middleware.offlinesync.repository.TransactionRepository;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private static final String CLASSNAME = TransactionService.class.getSimpleName();

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    FruitService fruitService;

    public List<Fruit> insertAllTransactions(List<Transaction> transactions) {
        transactions.sort(Comparator.comparing(Transaction::getTransactionDate));

        logger.info(CLASSNAME + ".insertAllTransactions() enter");
        for (Transaction transaction : transactions) {
            UUID generatedTransactionID = transaction.getTransactionID() == null || transaction.getTransactionID().toString().isEmpty() ? UUID.randomUUID() : transaction.getTransactionID();
            transaction.setTransactionID(generatedTransactionID);

            logger.info(CLASSNAME + ".insertAllTransactions() start transaction for ID" + transaction.getTransactionID());

            TransactionStatus status = fruitService.updateFruitUsingTransaction(transaction);
            transaction.setStatus(status);

            transactionRepository.save(transaction);
        }

        return fruitService.getAllFruits();
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}