package com.example.Cosmetic.Service;

import com.example.Cosmetic.Model.Cosmetic;
import com.example.Cosmetic.Repository.CosmeticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CosmeticService {

    @Autowired
    private CosmeticRepository cosmeticRepository;


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




}
