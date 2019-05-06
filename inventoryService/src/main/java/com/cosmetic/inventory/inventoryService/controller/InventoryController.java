package com.cosmetic.inventory.inventoryService.controller;

import com.cosmetic.inventory.inventoryService.service.InventoryService;
import com.cosmetic.inventory.inventoryService.service.TokenService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/inventory")
@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private TokenService tokenService;

//    @GetMapping("/all")
//    public List<Cosmetic> getItemByUsername(@RequestHeader){
//        return inventoryService.getInventoryByUsername(username);
//    }

    @DeleteMapping("")
    public void removeItem(@RequestHeader (value = "Authorization") String token, @RequestParam String id){
        Long idLong = Long.parseLong(id);
        String username = tokenService.getUsernameFromToken(token);
        inventoryService.removeItem(username, idLong);
    }

    @PostMapping("")
    public void addItem(@RequestHeader (value = "Authorization") String token, @RequestParam String id){
        Long idLong = Long.parseLong(id);
        String username = tokenService.getUsernameFromToken(token);
        inventoryService.addItem(username, idLong);
    }




}
