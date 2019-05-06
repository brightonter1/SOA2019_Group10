package com.example.statement.service;

import com.example.statement.model.Statement;
import com.example.statement.repository.StatementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class StatementService {

    @Autowired
    private StatementRepository statementRepository;

    public List<Statement> getStatementByUsername(String username) {
        return statementRepository.findAllByUsername(username);
    }

    public void addStatementByUsername(Statement statement) throws ParseException {
        Logger logger = LoggerFactory.getLogger(StatementService.class);
        //statement.convertDate(statement.getCreate_date()).toString();
        //logger.info(String.valueOf(statement.convertDate(String.valueOf(statement.getCreate_date()))));
        statementRepository.save(statement);
        //logger.info(statement.getCreate_date().toString());
    }

    public void DeleteStatementById(Long id){
        statementRepository.deleteById(id);
    }
}
