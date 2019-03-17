package com.demo.cosmetic.Category;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CategoryService {

    //private Category category;

    List<Category> categories = new ArrayList<>(Arrays.asList(
            new Category("Hair"),
            new Category("Skin"),
            new Category("Lip")
    ));

    //Get All Category
    public List getAllCategories(){
        return categories;
    }
    //Delete Category


}
