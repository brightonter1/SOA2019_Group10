package com.demo.cosmetic.Statement;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StatementService {

    private StatementArray statementArray = new StatementArray();

    public ArrayList<Statement> getStatementReport(String id){
        Statement statement = new Statement();

        if(statementArray.size() == 0){

            statement.setPrice("10000");
            statement.setUser(id);
            statement.setItemName("lipstick");
            statement.setDate("01/02/1997");
            addStatementToReport(statement);

        }

        return  statementArray.getStatements();
    }

    public void addStatementToReport(Statement statement){
        statementArray.addStatement(statement);
    }

}
