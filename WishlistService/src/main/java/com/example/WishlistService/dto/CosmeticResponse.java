package com.example.WishlistService.dto;

import com.example.WishlistService.Model.Cosmetic;

import java.util.List;

public class CosmeticResponse {

    private List<Cosmetic> cosmetics;

    public CosmeticResponse(List<Cosmetic> cosmetics) {
        this.cosmetics = cosmetics;
    }

    public CosmeticResponse() {
    }

    public List<Cosmetic> getCosmetics() {
        return cosmetics;
    }

    public void setCosmetics(List<Cosmetic> cosmetics) {
        this.cosmetics = cosmetics;
    }
}
