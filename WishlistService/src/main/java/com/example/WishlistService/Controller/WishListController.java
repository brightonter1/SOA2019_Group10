package com.example.WishlistService.Controller;

import com.example.WishlistService.Model.Cosmetic;
import com.example.WishlistService.Model.Wishlist;
import com.example.WishlistService.Repository.WishListRepository;
import com.example.WishlistService.Service.UserService;
import com.example.WishlistService.Service.WishListService;
import com.example.WishlistService.dto.CustomResponse;
import com.example.WishlistService.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WishListController {

    @Autowired
    private WishListService wishListService;
    private RestTemplate restTemplate;
    private List<Wishlist> cosmetics;
    private Wishlist empty;
    private List<Long> box;
    private List<Cosmetic> cosList;
    @Autowired
    private WishListRepository wishListRepository;

    public WishListController(){
        this.restTemplate = new RestTemplate();
        this.cosmetics = new ArrayList<>();
        this.empty = new Wishlist();
        this.cosList = new ArrayList<>();
    }

    @RequestMapping(value = "wishlist/{username}", method = RequestMethod.GET)
    public List<Cosmetic> getProductList(@PathVariable String username) {

            Logger logger = LoggerFactory.getLogger(WishListController.class);
            if (wishListRepository.findAllByUsername(username).size() > 0 ){
                box = wishListRepository.findAllByUsername(username).get(0).getId();
                cosList.clear();
                logger.info(box.toString());
                for(int i = 0; i < box.size() ; i++){
                    cosList.add(restTemplate.getForObject("http://localhost:8091/cosmetics/" + box.get(i), Cosmetic.class));
                }
                logger.info(cosList.toString());
            }else{
                return cosList;
            }

        return cosList;
    }

    @GetMapping("/wishlist")
    public List<Wishlist> start(){
        return wishListService.getAllItem();
    }


    @RequestMapping(value = "/wishlist/{username}", method = RequestMethod.POST)
    public void addItem(@PathVariable String username, @RequestParam Long id){
        wishListService.addItem(username,id);
    }

    @RequestMapping(value = "/wishlist/{username}", method = RequestMethod.DELETE)
    public void delItem(@PathVariable String username, @RequestParam Long id){
        wishListService.removeItem(username, id);
    }

}
