package com.example.WishlistService.Service;

import com.example.WishlistService.Model.Wishlist;
import com.example.WishlistService.Repository.WishListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishListService {

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private TokenService tokenService;

    private ArrayList<Wishlist> wishlist;
    private List<Long> array;
    private Wishlist empty;



    public WishListService(){
        empty = new Wishlist();
        array = new ArrayList<>();
        wishlist = new ArrayList<>();
    }

    public void addItem(String token, Long id){
        String username = tokenService.getUsernameFromToken(token);
        array = new ArrayList<>();
        wishlist = (ArrayList<Wishlist>) wishListRepository.findAllByUsername(username);
        if (!wishlist.isEmpty()){
            empty = wishlist.get(0);
            array = empty.getId();


            int count = 1;
            for (int i = 0 ; i < array.size() ; i++){
                if (array.get(i).equals(id)){
                    count = 0;
                }
            }

            if (count == 1){
                array.add(id);
                empty.setId(array);
                wishListRepository.save(empty);
            }
        }else{
            array.add(id);
            empty.setUsername(username);
            empty.setId(array);
            wishListRepository.save(empty);
        }
    }

    public void removeItem(String username, Long id) {
        wishlist = (ArrayList<Wishlist>) wishListRepository.findAllByUsername(username);
        empty = wishlist.get(0);
        array = empty.getId();

        for (int i = 0 ; i < array.size() ; i++){
            if (array.get(i).equals(id)){
                array.remove(i);
                empty.setId(array);
                wishListRepository.save(empty);
                break;
            }
        }
    }

    public List<Wishlist> getAllItem(){
        return (List<Wishlist>) wishListRepository.findAll();
    }
}
