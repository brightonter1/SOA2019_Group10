package com.demo.cosmetic.Statement;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StatementService {

    private StatementArray statementArray = new StatementArray();

    public ArrayList<Statement> getStatementReport(){
        return  statementArray.getStatements();
    }

    public void addStatementToReport(Statement statement){
        statementArray.addStatement(statement);
    }

}
