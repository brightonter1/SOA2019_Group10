package com.example.CosmeticService.Service;

import com.example.CosmeticService.Model.Cosmetic;
import com.example.CosmeticService.Repository.CosmeticRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CosmeticService {

    @Autowired
    private CosmeticRepository cosmeticRepository;
    private ArrayList<Cosmetic>  cosmetics;

    public CosmeticService(){
        cosmetics = new ArrayList<>();
    }

    public List<Cosmetic> getAllCosmetic(){
        return (List<Cosmetic>) cosmeticRepository.findAllByOrderById();
    }

    public void addCosmetic(Cosmetic cosmetic){
        cosmeticRepository.save(cosmetic);
    }

    public void removeCosmetic(Long id){
        cosmeticRepository.deleteById(id);
    }

    public Optional<Cosmetic> getItemById(Long id){
        return cosmeticRepository.findById(id);
    }


    public List<Cosmetic> getAllByTag(String tag){
        Logger logger = LoggerFactory.getLogger(CosmeticService.class);
        cosmetics = (ArrayList<Cosmetic>) cosmeticRepository.findAllByOrderById();
        logger.info(cosmetics.toString());
        return cosmeticRepository.findAllByCategory(tag);
    }

}
