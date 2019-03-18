package com.demo.cosmetic.Wishlist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishlistService  {


    List<Wishlist> wishlists = new ArrayList<>(Arrays.asList(
            new Wishlist("CM002", "Body Care", "", "Body", "99", "Bright"),
            new Wishlist("CM003", "Color Hair", "", "Hair", "659", "Pond"),
            new Wishlist("CM001", "Skincare", "", "Face", "149", "Bright")

    ));


    // Get Wishlist By Username
    public List<Wishlist> getWishlist(String username){
        return wishlists.stream()
                .filter(w -> w.getUser().toLowerCase().equals(username))
                .collect(Collectors.toList());
    }

    // Add Wishlist By Username
    public String addWishlist(Wishlist wishlist, String username){
        wishlist.setUser(username);
        wishlists.add(wishlist);
        return "Add Wishlist Complete";
    }

    // Remove Wishlist By Username
    public String removeWishlist(Wishlist wishlist, String username){
        wishlist.setUser(username);
        wishlists.removeIf(w -> w.getCosmeticId().equals(wishlist.getCosmeticId())
                && w.getUser().toLowerCase().equals(username)
        );
        return "Remove Wishlist Complete";
    }


}

