package com.example.Cosmetic.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
public class Color implements Serializable {

    @JsonIgnore
    private String colour_name;

    @JsonIgnore
    private String hex_value;
}
