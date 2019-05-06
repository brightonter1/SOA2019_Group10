package com.cosmetic.inventory.inventoryService.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private Long itemid;
    private String name;
    private String brand;
    private double price;
    private String create_at;
    private String exp_at;
    private String image_link;




}
