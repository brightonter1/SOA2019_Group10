package com.example.CosmeticService.Controller;

import com.example.CosmeticService.Model.Cosmetic;
import com.example.CosmeticService.Service.CosmeticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RequestMapping("/cosmetics")
@RestController
public class CosmeticController {

    @Autowired
    private CosmeticService cosmeticService;

    @GetMapping("/")
    public List<Cosmetic> getAllCosmetic(){
        return cosmeticService.getAllCosmetic();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addCosmetic(@RequestBody Cosmetic cosmetic){
        cosmeticService.addCosmetic(cosmetic);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeCosmetic(@PathVariable Long id){
        cosmeticService.removeCosmetic(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Cosmetic> getItemById(@PathVariable Long id){
        return cosmeticService.getItemById(id);

    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public List<Cosmetic> getAllById(){
//        return cosmeticService.getAllById();
//    }



}
