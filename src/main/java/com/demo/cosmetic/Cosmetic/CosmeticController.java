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
    @RequestMapping("cosmeticss/search/{keyword}")
    public List<Cosmetic> searchKeyword(@PathVariable String keyword){
        return cosmeticService.searchCosmeticsByKeyword(keyword.toLowerCase());
    }

}
