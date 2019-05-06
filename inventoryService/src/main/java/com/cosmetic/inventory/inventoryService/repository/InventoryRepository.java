package com.cosmetic.inventory.inventoryService.repository;

import com.cosmetic.inventory.inventoryService.model.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {

}
