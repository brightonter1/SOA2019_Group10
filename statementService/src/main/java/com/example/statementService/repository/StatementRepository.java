package com.example.statementService.repository;


import com.example.statementService.model.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StatementRepository extends JpaRepository<Statement, Long> {

//    List<Statement> findAllByUsernameOrderByCreate_date(String username);


    @Override
    void deleteById(Long aLong);

    Optional<Statement> findByUsername(String username);

    List<Statement> findAllByUsername(String username);
}
