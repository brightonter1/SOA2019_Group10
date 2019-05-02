package com.example.Cosmetic.Repository;

import com.example.Cosmetic.Model.Cosmetic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CosmeticRepository extends CrudRepository<Cosmetic,Long> {

    List<Cosmetic> findAllByOrderById();

}
