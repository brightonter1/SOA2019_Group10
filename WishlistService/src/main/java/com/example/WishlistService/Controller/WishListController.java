package com.example.WishlistService.Controller;

import com.example.WishlistService.Model.Cosmetic;
import com.example.WishlistService.Model.Wishlist;
import com.example.WishlistService.Repository.WishListRepository;
import com.example.WishlistService.Service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/wishlist")
@RestController
public class WishListController {

    @Autowired
    private WishListService wishListService;
    private RestTemplate restTemplate;

    public WishListController(){
        this.restTemplate = new RestTemplate();
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public List<Cosmetic> getProductList() {
//
//        return (List<Cosmetic>) restTemplate.getForObject("http://localhost:8091/cosmetics/hello", Cosmetic.class);
//    }

    @GetMapping("")
    public List<Wishlist> start(){
        return wishListService.getAllItem();
    }


    @RequestMapping(value = "/{username}", method = RequestMethod.POST)
    public void addItem(@PathVariable String username, @RequestParam Long id){
        wishListService.addItem(username,id);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    public void delItem(@PathVariable String username, @RequestParam Long id){
        wishListService.removeItem(username, id);
    }

}
