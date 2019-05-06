package com.cosmetic.inventory.inventoryService.exception;

import com.cosmetic.inventory.inventoryService.model.Inventory;

import java.util.List;

public class InventoryResponse {

    private List<Inventory> inventory;

    public InventoryResponse(List<Inventory> inventory) {
        this.inventory = inventory;
    }

    public InventoryResponse() {
    }

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<Inventory> inventory) {
        this.inventory = inventory;
    }
}
