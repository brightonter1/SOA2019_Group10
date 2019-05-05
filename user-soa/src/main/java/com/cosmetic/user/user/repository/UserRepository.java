package com.cosmetic.user.user.repository;

import com.cosmetic.user.user.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDomain, Integer> {

    boolean existsByUsername(String username);

    UserDomain findByUsername(String username);
}
