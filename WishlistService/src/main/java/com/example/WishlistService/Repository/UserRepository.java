package com.example.WishlistService.Repository;

import com.example.WishlistService.Model.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<UserDomain, Integer> {

    boolean existsByUsername(String username);

    UserDomain findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);
}
