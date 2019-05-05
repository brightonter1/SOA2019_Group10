package com.example.WishlistService.Repository;

import com.example.WishlistService.Model.Wishlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends CrudRepository<Wishlist, String> {

    List<Wishlist> findAllByUsername(String username);
    List<Wishlist> findAll();


}
