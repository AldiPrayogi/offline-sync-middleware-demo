package de.commsult.middleware.offlinesync.repository;

import de.commsult.middleware.offlinesync.entity.Transaction;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, UUID>{
    
}
