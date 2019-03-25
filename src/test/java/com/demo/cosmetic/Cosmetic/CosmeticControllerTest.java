package com.demo.cosmetic.Cosmetic;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CosmeticControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void getAllCosmetics(){
        List cosmetics = restTemplate.getForObject("/cosmetics", List.class);
        CosmeticService CS = new CosmeticService();
        assertEquals("[{cosmeticId=NO001, imagePath=, name=Soap, category=Body, exp=01/02/2017, price=39}," +
                " {cosmeticId=NO002, imagePath=, name=Shampoo, category=Body, exp=12/02/2018, price=149}," +
                " {cosmeticId=NO003, imagePath=, name=Conditioner, category=Face, exp=16/02/2019, price=139}," +
                " {cosmeticId=NO004, imagePath=, name=Body Lotion, category=Body, exp=30/02/2012, price=249}," +
                " {cosmeticId=NO005, imagePath=, name=Makeup, category=Face, exp=05/02/2017, price=99}," +
                " {cosmeticId=NO006, imagePath=, name=Oral Care, category=Hair, exp=07/02/2015, price=129}," +
                " {cosmeticId=NO007, imagePath=, name=Lip, category=Face, exp=22/02/2021, price=59}]", cosmetics.toString());
    }



}
