package com.cosmetic.inventory.inventoryService.repository;

import com.cosmetic.inventory.inventoryService.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findById(Long aLong);
    List<Inventory> findAllByUsername(String username);

}
