package com.demo.cosmetic.Cosmetic;

public class Cosmetic {
    private String cosmeticId;
    private String imagePath;
    private String name;
    private String category;
    private String exp;
    private String price;


    public Cosmetic(){}

    public Cosmetic(String cosmeticId, String imagePath, String name, String category, String exp, String price){
        this.cosmeticId = cosmeticId;
        this.imagePath = imagePath;
        this.name = name;
        this.category = category;
        this.exp = exp;
        this.price = price;

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCosmeticId() {
        return cosmeticId;
    }

    public void setCosmeticId(String cosmeticId) {
        this.cosmeticId = cosmeticId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
