package com.example.app.Wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    // Get Wishlist by Username
    @GetMapping("/{username}/wishlist")
    public List<Wishlist> getWishlist(@PathVariable String username){
        return wishlistService.getWishlist(username.toLowerCase());
    }

    // Add Wishlist by Username
    @RequestMapping(value = "/{username}/wishlist", method = RequestMethod.POST)
    public String addWishlist(@RequestBody Wishlist wishlist, @PathVariable String username){
        return wishlistService.addWishlist(wishlist, username);
    }

    // Remove Wishlist by Username
    @RequestMapping(value = "/{username}/wishlist", method = RequestMethod.DELETE)
    public String removeWishlist(@RequestBody Wishlist wishlist, @PathVariable String username){
        return wishlistService.removeWishlist(wishlist, username.toLowerCase());
    }

}
