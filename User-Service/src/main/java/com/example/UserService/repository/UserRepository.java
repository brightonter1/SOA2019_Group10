package com.example.UserService.repository;

import com.example.UserService.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDomain, Integer> {

    boolean existsByUsername(String username);

    UserDomain findByUsername(String username);
}
