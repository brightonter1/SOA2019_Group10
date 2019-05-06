package com.cosmetic.inventory.inventoryService.controller;

import com.cosmetic.inventory.inventoryService.model.Item;
import com.cosmetic.inventory.inventoryService.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/inventory")
@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

//    @GetMapping("/{username}/all")
//    public List<Cosmetic> getItemByUsername(@PathVariable String username){
//        return inventoryService.getInventoryByUsername(username);
//    }

    @PostMapping("/{username}")
    public void addItem(@PathVariable String username, @RequestBody Item item){
        inventoryService.addItem(username, item);
    }

}
