package com.demo.cosmetic.Statement;

public class Statement {


        private String date;
        private String itemName;
        private String price;

        public Statement() {
        }

        public Statement(String date, String itemName, String price) {
            this.date = date;
            this.itemName = itemName;
            this.price = price;
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
