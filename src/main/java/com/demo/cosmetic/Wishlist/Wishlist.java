package com.demo.cosmetic.Wishlist;

public class Wishlist {
    private String cosmeticId;
    private String itemName;
    private String imagePath;
    private String category;
    private String price;
    private String user;

    public Wishlist() {
    }

    public Wishlist(String cosmeticId, String itemName, String imagePath, String category, String price, String user) {
        this.cosmeticId = cosmeticId;
        this.itemName = itemName;
        this.imagePath = imagePath;
        this.category = category;
        this.price = price;
        this.user = user;
    }

    public String getCosmeticId() {
        return cosmeticId;
    }

    public void setCosmeticId(String cosmeticId) {
        this.cosmeticId = cosmeticId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
