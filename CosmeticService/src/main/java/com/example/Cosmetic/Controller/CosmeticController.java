package com.example.Cosmetic.Controller;

import com.example.Cosmetic.Model.Cosmetic;
import com.example.Cosmetic.Service.CosmeticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class CosmeticController {

    @Autowired
    private CosmeticService cosmeticService;

    @GetMapping("/greeting")
    public String greeting() {
        return "index";
    }

//    @RequestMapping("/")
//    public ModelAndView cosmetic() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("index");
//        return mav;
//    }

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

    @RequestMapping(value = "cosmetics/{id}", method = RequestMethod.GET)
    public Optional<Cosmetic> findItemById(@PathVariable Long id){
        return cosmeticService.findItemById(id);
    }
}
