package com.cosmetic.inventory.inventoryService.service;

import com.cosmetic.inventory.inventoryService.model.Inventory;
import com.cosmetic.inventory.inventoryService.model.Item;
import com.cosmetic.inventory.inventoryService.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    private RestTemplate restTemplate;
    private Inventory inventory;
    private List<Item> items;

    public InventoryService(){
        this.inventory = new Inventory();
        this.items = new ArrayList<>();
        this.restTemplate = new RestTemplate();
    }

    public void addItem(String username, Item item){
        Logger logger = LoggerFactory.getLogger(InventoryService.class);

        logger.info(username + " " + item.toString());

        items.add(item);
        inventory.setUsername(username);
        inventory.setItemList(items);
        inventoryRepository.save(inventory);

    }



}
