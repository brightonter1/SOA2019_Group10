package com.demo.cosmetic.Wishlist;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WishlistControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void getWishlist(){

        //Tl.add(wh);
        List Lwishlist = restTemplate.getForObject("/Bright/wishlist", ArrayList.class);
        assertEquals("[{cosmeticId=CM002, itemName=Body Care, imagePath=, category=Body, price=99, user=Bright}, " +
                "{cosmeticId=CM001, itemName=Skincare, imagePath=, category=Face, price=149, user=Bright}]", Lwishlist.toString());
    }
}
