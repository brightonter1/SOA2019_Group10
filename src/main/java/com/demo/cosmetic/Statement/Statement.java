package com.demo.cosmetic.Statement;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Statement {

        @Id
//        @GeneratedValue(strategy = GenerationType.AUTO)
        private String date;
        private String itemName;
        private String price;
        private String id;

        public Statement() {
        }

    public Statement(String date, String itemName, String price, String user) {
        this.date = date;
        this.itemName = itemName;
        this.price = price;
        this.id = user;
    }

    public String getUser() {
        return id;
    }

    public void setUser(String user) {
        this.id = user;
    }

    public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
}
