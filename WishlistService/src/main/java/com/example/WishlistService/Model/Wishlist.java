package com.example.WishlistService.Model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Embeddable
@Data
@Entity
public class Wishlist {

    @Id
    private String username;

    @ElementCollection
    private List<Long> id;

    public Wishlist() {
    }

    public Wishlist(String username, List<Long> id) {
        this.username = username;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Long> getId() {
        return id;
    }

    public void setId(List<Long> id) {
        this.id = id;
    }
}
