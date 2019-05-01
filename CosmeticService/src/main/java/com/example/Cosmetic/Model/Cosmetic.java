package com.example.Cosmetic.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Embeddable
public class Cosmetic{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String brand;
    private double price;
    @JsonIgnore
    @Transient
    private char price_sign;
    @JsonIgnore
    @Transient
    private String currency;

    private String image_link;
    @JsonIgnore
    @Transient
    private String product_link;
    @JsonIgnore
    @Transient
    private String website_link;
    private String description;

    @JsonIgnore
    @Transient
    private String rating;
    private String category;

    @JsonIgnore
    @Transient
    private String product_type;

    @ElementCollection
    @JsonIgnore
    @Transient
    private List<String> tag_list;


    private String created_at;
    private String exp_at;

    @JsonIgnore
    @Transient
    private String updated_at;
    @JsonIgnore
    @Transient
    private String product_api_url;
    @JsonIgnore
    @Transient
    private String api_featured_image;

    @Embedded
    @ElementCollection
    @JsonIgnore
    @Transient
    private List<Color> product_colors;


    public void setPrice(double price) {
        this.price = price*33;
    }


}

