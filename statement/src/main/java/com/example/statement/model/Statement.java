package com.example.statement.model;

import com.example.statement.service.StatementService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
public class Statement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private Date create_date;
    private Date exp_date;
    private String itemname;
    private double price;

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getExp_date() {
        return exp_date;
    }

    public void setExp_date(Date exp_date) {
        this.exp_date = exp_date;
    }

    public Date convertDate(Date d) throws ParseException {
        String newDate = new SimpleDateFormat("MM-dd-yyyy").format(d);
        Logger logger = LoggerFactory.getLogger(StatementService.class);
        //logger.info(newDate);
////        String d = getCreate_date().toString();
//        //d = d.split(" ")[0];
//        String[] ds = d.split(" ");
//        String dc = ds[0]+"-"+ds[1]+"-"+ds[2];
        SimpleDateFormat formatter1 = new SimpleDateFormat("MM-dd-yyyy");
        Date date1;
//
        date1 = formatter1.parse(newDate);
        logger.info(newDate);
        logger.info(date1.toString());
        return date1;


    }
}
