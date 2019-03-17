package com.demo.cosmetic.Cosmetic;

public class Cosmetic {
    private String cosmeticId;
    private String imagePath;
    private String name;
    private String category;
    private String exp;
    private String price;
    private String listByUsername;
    private String wishListByUsername;

    public Cosmetic(){}

    public Cosmetic(String cosmeticId, String imagePath, String name, String exp, String category, String price, String listByUsername, String wishListByUsername){
        this.cosmeticId = cosmeticId;
        this.imagePath = imagePath;
        this.name = name;
        this.category = category;
        this.exp = exp;
        this.price = price;
        this.listByUsername = listByUsername;
        this.wishListByUsername = wishListByUsername;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getListByUsername() {
        return listByUsername;
    }

    public void setListByUsername(String listByUsername) {
        this.listByUsername = listByUsername;
    }

    public String getWishListByUsername() {
        return wishListByUsername;
    }

    public void setWishListByUsername(String wishListByUsername) {
        this.wishListByUsername = wishListByUsername;
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
