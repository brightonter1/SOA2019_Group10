package com.cosmetic.inventory.inventoryService.repository;

import com.cosmetic.inventory.inventoryService.model.Cosmetic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CosmeticRepository extends JpaRepository<Cosmetic, Long> {

    Optional<Cosmetic> findById(Long aLong);
}
