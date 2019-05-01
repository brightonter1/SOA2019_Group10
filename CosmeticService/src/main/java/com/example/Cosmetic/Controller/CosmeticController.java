package com.example.Cosmetic.Controller;

import com.example.Cosmetic.Model.Cosmetic;
import com.example.Cosmetic.Service.CosmeticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class CosmeticController {

    @Autowired
    private CosmeticService cosmeticService;

    @GetMapping("/cosmetics")
    public List<Cosmetic> getAllCosmetic() throws IOException {
        return cosmeticService.getAllCosmetic();
    }

    @RequestMapping(value = "/cosmetics", method = RequestMethod.POST)
    public void addCosmetic(@RequestBody Cosmetic cosmetic){
        cosmeticService.addCosmetic(cosmetic);
    }

    @RequestMapping(value = "/cosmetics/{id}", method = RequestMethod.DELETE)
    public void removeCosmetic(@PathVariable Long id){
        cosmeticService.removeCosmetic(id);
    }
}
