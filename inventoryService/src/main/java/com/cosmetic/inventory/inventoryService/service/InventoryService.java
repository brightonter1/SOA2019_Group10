package com.cosmetic.inventory.inventoryService.service;

import com.cosmetic.inventory.inventoryService.controller.InventoryController;
import com.cosmetic.inventory.inventoryService.exception.CustomException;
import com.cosmetic.inventory.inventoryService.exception.CustomResponse;
import com.cosmetic.inventory.inventoryService.exception.InventoryResponse;
import com.cosmetic.inventory.inventoryService.model.Cosmetic;
import com.cosmetic.inventory.inventoryService.model.Inventory;
import com.cosmetic.inventory.inventoryService.repository.CosmeticRepository;
import com.cosmetic.inventory.inventoryService.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private CosmeticRepository cosmeticRepository;

    @Autowired
    private TokenService tokenService;



    public void addItem(String username, Long id){
        Cosmetic cosmetic = cosmeticRepository.findById(id).get();
        Inventory inv = new Inventory();
        inv.setUsername(username);
        inv.setName(cosmetic.getName());
        inv.setBrand(cosmetic.getBrand());
        inv.setCreate_at(String.valueOf(new Date().getTime()));
        inv.setExp_at(null);
        inv.setPrice(cosmetic.getPrice());
        inv.setImage_link(cosmetic.getImage_link());
        inv.setItemid(cosmetic.getId());
        inventoryRepository.save(inv);
    }

    public void removeItem(String username, Long id){
        Logger logger = LoggerFactory.getLogger(InventoryService.class);

        List<Inventory> inventory = inventoryRepository.findAllByUsername(username);

        logger.info(inventory.toString());
        for (int i = 0 ; i < inventory.size() ; i++){
            if (inventory.get(i).getId().equals(id)){
                inventoryRepository.delete(inventory.get(i));
            }
        }
    }


    public ResponseEntity<InventoryResponse> getInventoryByUsername(String token) {
        try{
            if(tokenService.validateToken(token)){
                String username = tokenService.getUsernameFromToken(token);
                List<Inventory> inventories = inventoryRepository.findAllByUsername(username);
                return new ResponseEntity<InventoryResponse>(new InventoryResponse(inventories), HttpStatus.OK);
            }else {
                throw new CustomException("failed", HttpStatus.UNPROCESSABLE_ENTITY);
            }

        }catch (Exception ex){
            throw new CustomException("failed feiled", HttpStatus.UNPROCESSABLE_ENTITY);
        }




    }
}
