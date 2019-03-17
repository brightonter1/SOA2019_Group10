package com.demo.cosmetic.Cosmetic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CosmeticService {

    private Cosmetic cosmetic;

    private List<Cosmetic> cosmetics = new ArrayList<>(Arrays.asList(
            new Cosmetic("NO001", "", "Soap", "Body","01/02/2017", "39","Bright", "Game"),
            new Cosmetic("NO002", "", "Shampoo","Body", "12/02/2018", "149", "Game", ""),
            new Cosmetic("NO003", "", "Conditioner","Face", "16/02/2019", "139", "Bright", ""),
            new Cosmetic("NO004", "", "Body Lotion","Body","30/02/2012", "249", "Game" ,"Pond"),
            new Cosmetic("NO005", "", "Makeup","Face", "05/02/2017", "99", "Pond" , "Game"),
            new Cosmetic("NO006", "", "Oral Care", "Hair","07/02/2015", "129", "", "Game"),
            new Cosmetic("NO007", "", "Lip", "Face", "22/02/2021", "59", "", "Game")
    ));

    // Get All Cosmetics
    public List<Cosmetic> getAllCosmetics(){
        return cosmetics;
    }

    // Get All Cosmetics By User
    public List<Cosmetic> getAllCosmeticsByUser(String username){

        return cosmetics.stream()
                .filter(c -> c.getListByUsername().toLowerCase().equals(username))
                .collect(Collectors.toList());

    }

    // Add Cosmetic By User
//    public void addCosmeticByUser(String username, Cosmetic cos){
//        cos.setListByUsername(username);
//        cosmetics.add(cos);
//    }










}
