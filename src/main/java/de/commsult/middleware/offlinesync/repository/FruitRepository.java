package de.commsult.middleware.offlinesync.repository;

import de.commsult.middleware.offlinesync.entity.Fruit;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, UUID>{
    
}
