package com.example.app.Cosmetic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CosmeticService {


    private List<Cosmetic> cosmetics = new ArrayList<>(Arrays.asList(
            new Cosmetic("NO001", "", "Soap", "Body","01/02/2017", "39"),
            new Cosmetic("NO002", "", "Shampoo","Body", "12/02/2018", "149"),
            new Cosmetic("NO003", "", "Conditioner","Face", "16/02/2019", "139"),
            new Cosmetic("NO004", "", "Body Lotion","Body","30/02/2012", "249"),
            new Cosmetic("NO005", "", "Makeup","Face", "05/02/2017", "99"),
            new Cosmetic("NO006", "", "Oral Care", "Hair","07/02/2015", "129"),
            new Cosmetic("NO007", "", "Lip", "Face", "22/02/2021", "59")
    ));

    // Get All Cosmetics
    public List<Cosmetic> getAllCosmetics(){
        return cosmetics;
    }

    // Search Cosmetic
    public List<Cosmetic> searchCosmeticsByKeyword(String key){
        return cosmetics.stream()
                .filter(c -> c.getCategory().toLowerCase().equals(key))
                .collect(Collectors.toList());
    }

}
