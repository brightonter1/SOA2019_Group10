package com.cosmetic.inventory.inventoryService.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
public class Item {

    @Id
    private Long id;

    private String create_at;
    private String exp_at;
}
