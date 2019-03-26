package com.example.app.Statement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class StatementController {

    @Autowired
    private StatementService statementService;

    // Get Reported Statement
    @RequestMapping(value = "/statement/{id}", method = RequestMethod.GET)
    public ArrayList<Statement> getStatementById(@PathVariable String id){

        return statementService.getStatementReportById(id);
    }

    @RequestMapping(value = "/statement", method = RequestMethod.GET)
    public ArrayList<Statement> getAllStatement(){
        return statementService.getAllStatementReport();
    }


}
