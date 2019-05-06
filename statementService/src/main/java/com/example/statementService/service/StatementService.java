package com.example.statementService.service;

import com.example.statementService.model.Statement;
import com.example.statementService.repository.StatementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class StatementService {

    @Autowired
    private StatementRepository statementRepository;

    @Autowired
    private TokenService tokenService;

    public List<Statement> getStatementByUsername(String username) {
        return statementRepository.findAllByUsername(username);
    }

    public void addStatementByUsername(String username, Statement statement) throws ParseException {
        statement.setUsername(username);
        statementRepository.save(statement);
    }

    public void DeleteStatementById(String token, Long id){

        if(tokenService.validateToken(token)){
            statementRepository.deleteById(id);
        }

    }
}
