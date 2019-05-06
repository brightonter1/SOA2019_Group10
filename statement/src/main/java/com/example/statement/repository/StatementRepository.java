package com.example.statement.repository;


import com.example.statement.model.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatementRepository extends JpaRepository<Statement, Long> {

    List<Statement> findAllByUsername(String username);
//    List<Statement> findAllByUsernameOrderByCreate_date(String username);

}
