package com.example.app.Statement;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class StatementService {


    private ArrayList<Statement> statements = new ArrayList<Statement>(Arrays.asList(new Statement(
            "01/07/1997", "lipstick", "1000", "game"), new Statement(
            "01/07/1997", "lipstick", "1000", "jame"), new Statement(
            "01/07/1997", "eiseis", "1000", "game"), new Statement(
                    "01/02/1997", "lipstick", "10000", "pond"
            )
    ));

    public ArrayList<Statement> getStatementReportById(String id){
        System.out.println("Statment By Id : " + id);
        ArrayList<Statement> selectedStatement = new ArrayList<Statement>();
        boolean status = true;
        int count = 0;
        while(status){
            System.out.println(count);

            if(statements.get(count).getUser().equals(id)){
                selectedStatement.add(statements.get(count));
                System.out.println("Id : " + statements.get(count).getUser());
            }
            count++;
            if(statements.size() == count){
                status = false;
            }
        }
        return  selectedStatement;
    }

        public ArrayList<Statement> getAllStatementReport(){
            return statements;
        }

}
