package com.demo.cosmetic.Statement;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StatementControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void getStatement(){
        List stateList  = restTemplate.getForObject("/user/pond/statement", List.class);
        assertEquals("[{date=01/02/1997, itemName=lipstick, price=10000, user=pond}]", stateList.toString());
    }

}
