package com.demo.cosmetic.Cosmetic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CosmeticController {

    @Autowired
    private CosmeticService cosmeticService;

    // Get All Cosmetics
    @RequestMapping("/cosmetics")
    public List<Cosmetic> getAllCosmetic(){
        return cosmeticService.getAllCosmetics();
    }

    // Search Cosmetics by Key
    @RequestMapping("cosmetic/search/{keyword}")
    public List<Cosmetic> searchKeyword(@PathVariable String keyword){
        return cosmeticService.searchCosmeticsByKeyword(keyword.toLowerCase());
    }


    // Add Cosmetic by User
//    @RequestMapping(value = "/user/{username}/cosmetic/information",
//            produces = "application/json",
//            method = RequestMethod.POST)
//    public void addCosmetic(@PathVariable String username, @RequestBody Cosmetic cosmetic){
//        cosmeticService.addCosmeticByUser(username, cosmetic);
//    }







}
