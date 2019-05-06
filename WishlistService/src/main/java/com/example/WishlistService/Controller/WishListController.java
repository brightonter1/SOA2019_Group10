package com.example.WishlistService.Controller;

import com.example.WishlistService.Model.Cosmetic;
import com.example.WishlistService.Model.Wishlist;
import com.example.WishlistService.Repository.WishListRepository;
import com.example.WishlistService.Service.TokenService;
import com.example.WishlistService.Service.WishListService;
import com.example.WishlistService.dto.CosmeticResponse;
import com.example.WishlistService.dto.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
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

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public String SayHello(){
        return "Hello wishlist-serive";
    }

    public WishListController(){
        this.restTemplate = new RestTemplate();
        this.cosmetics = new ArrayList<>();
        this.empty = new Wishlist();
        this.cosList = new ArrayList<Cosmetic>();
    }

    @GetMapping("/all")
    public ResponseEntity<CosmeticResponse> getProductList(@RequestHeader (value = "Authorization") String token) {
            String username = tokenService.getUsernameFromToken(token);
            Logger logger = LoggerFactory.getLogger(WishListController.class);
            if (wishListRepository.findAllByUsername(username).size() > 0) {
                box = wishListRepository.findAllByUsername(username).get(0).getId();
                cosList.clear();
                for (int i = 0; i < box.size(); i++) {
                    cosList.add(restTemplate.getForObject("http://localhost:8093/cosmetics/" + box.get(i), Cosmetic.class));
                }

                logger.info(cosList.toString());
                return new ResponseEntity<CosmeticResponse>(new CosmeticResponse(cosList), HttpStatus.OK);
            }else {
                throw new CustomException("fail get productlist wishlist", HttpStatus.UNPROCESSABLE_ENTITY);
            }
    }

    @PostMapping("/add")
    public void addItem(@RequestHeader (value = "Authorization") String token, @RequestParam Long id){
        wishListService.addItem(token,id);
    }


    @DeleteMapping("")
    public void delItem(@RequestHeader (value = "Authorization") String token, @RequestParam Long id){
        wishListService.removeItem(token, id);
    }

}
