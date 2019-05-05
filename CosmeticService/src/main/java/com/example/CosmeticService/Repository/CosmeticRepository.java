package com.example.CosmeticService.Repository;

import com.example.CosmeticService.Model.Cosmetic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CosmeticRepository extends CrudRepository<Cosmetic,Long> {

    List<Cosmetic> findAllByOrderById();
    List<Cosmetic> findAllById();

}
