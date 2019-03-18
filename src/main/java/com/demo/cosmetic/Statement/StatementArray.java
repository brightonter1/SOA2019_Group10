package com.demo.cosmetic.Statement;

import java.util.ArrayList;

public class StatementArray {
    private ArrayList<Statement> statements;

    public StatementArray(ArrayList<Statement> statements) {
        this.statements = statements;
    }

    public StatementArray() {
        statements = new ArrayList<Statement>();
    }

    public void addStatement(Statement statement){
        statements.add(statement);
    }

    public ArrayList<Statement> getStatements() {
        return statements;
    }
}
