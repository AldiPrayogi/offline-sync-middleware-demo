package de.commsult.middleware.offlinesync.service;

import de.commsult.middleware.offlinesync.entity.Fruit;
import de.commsult.middleware.offlinesync.entity.Transaction;
import de.commsult.middleware.offlinesync.enums.TransactionStatus;
import de.commsult.middleware.offlinesync.enums.TransactionType;
import de.commsult.middleware.offlinesync.repository.FruitRepository;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

    private static final String CLASSNAME = FruitService.class.getSimpleName();

    private static final Logger logger = LoggerFactory.getLogger(FruitService.class);

    @Autowired
    FruitRepository fruitRepository;

    public List<Fruit> getAllFruits() {
        logger.info(CLASSNAME + ".getAllFruits() enter");

        return fruitRepository.findAll(Sort.by(Sort.Direction.ASC, "fruitName"));
    }

    public TransactionStatus updateFruitUsingTransaction(Transaction transaction) {
        logger.info(CLASSNAME + ".updateFruitUsingTransaction() enter");
        Fruit existingFruit = this.getFruitByID(transaction.getFruitID());
        if (existingFruit != null) {
            int updatedQuantity = existingFruit.getQuantity() + this.getUpdatedQuantity(transaction.getType(), transaction.getQuantity());
            if (updatedQuantity < 0) {
                logger.error(CLASSNAME + ".updateFruitUsingTransaction() error");
                return TransactionStatus.FAILEDTRANS;
            }

            existingFruit.setQuantity(updatedQuantity);
            existingFruit.setSyncVersion(existingFruit.getSyncVersion() + 1);
            fruitRepository.save(existingFruit);
        }

        logger.info(CLASSNAME + ".updateFruitUsingTransaction() finished");
        return TransactionStatus.SUCCESSFULTRANS;
    }

    private Fruit getFruitByID(UUID fruitID) {
        return fruitRepository.findById(fruitID).orElse(null);
    }

    private int getUpdatedQuantity(TransactionType type, int qty) {
        return type == TransactionType.BUY ? qty : -qty;
    }

}
