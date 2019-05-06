package com.example.statement.controller;

import com.example.statement.model.Statement;
import com.example.statement.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RequestMapping("/statement")
@RestController
public class StatementController {

    @Autowired
    private StatementService statementService;

    @GetMapping("")
    public List<Statement> getStatementByUsername(@RequestParam String username){
        return statementService.getStatementByUsername(username);
    }

    @PostMapping("")
    public void addStatementByUsername(@RequestBody Statement statement) throws ParseException {
        statementService.addStatementByUsername(statement);
    }

    @DeleteMapping("")
    public void DeleteStatementByid(@RequestHeader (value = "Authorization") String token, @RequestParam Long id){
        String username = toket
        statementService.DeleteStatementById(username, id);
    }

}
