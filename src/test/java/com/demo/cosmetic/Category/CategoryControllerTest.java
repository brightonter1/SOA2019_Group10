package com.demo.cosmetic.Category;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


public class CategoryControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void getAllCategory(){
        List CategoryList = restTemplate.getForObject("/category", ArrayList.class);
        assertEquals("[{categoryName=Hair}, {categoryName=Skin}, {categoryName=Lip}]", CategoryList.toString());

    }



}
