package com.example.statementService.controller;

import com.example.statementService.model.Statement;
import com.example.statementService.service.StatementService;
import com.example.statementService.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RequestMapping("/statement")
@RestController
public class StatementController {

    @Autowired
    private StatementService statementService;
    @Autowired
    private TokenService tokenService;

    Logger logger = LoggerFactory.getLogger(StatementController.class);

    @GetMapping("")
    public List<Statement> getStatementByUsername(@RequestHeader (value = "Authorization") String token){
        String username = tokenService.getUsernameFromToken(token);
        return statementService.getStatementByUsername(username);
    }

    @PostMapping("")
    public void addStatementByUsername(@RequestHeader (value = "Authorization" ) String token , @RequestBody Statement statement) throws ParseException {
        String username = tokenService.getUsernameFromToken(token);
        statementService.addStatementByUsername(username, statement);
    }

    @DeleteMapping("")
    public void DeleteStatementByid(@RequestHeader (value = "Authorization") String token, @RequestParam Long id){
        statementService.DeleteStatementById(token, id);
    }

}
