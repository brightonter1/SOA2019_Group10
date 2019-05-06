package com.cosmetic.inventory.inventoryService.model;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class Inventory {

    @Id
    private String username;

    @ElementCollection
    private List<Item> itemList;

    public Inventory(String username, List<Item> itemList) {
        this.username = username;
        this.itemList = itemList;
    }

    public Inventory() {
    }


}
