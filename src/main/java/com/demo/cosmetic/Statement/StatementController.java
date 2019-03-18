package com.demo.cosmetic.Statement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class StatementController {

    @Autowired
    private StatementService statementService;

    // Get Reported Statement
    @RequestMapping("/user/{id}/statement")
    public ArrayList<Statement> getStatement(@PathVariable String id){
        return statementService.getStatementReport(id);
    }
}
